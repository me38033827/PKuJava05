import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// �������������X����
	private int comX = -1;
	// �������������Y����
	private int comY = -1;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		//playercount������ʾ��ǰ��ҵ������������computercount������ʾ��ǰ����������������
		int playercount=0,conputercount=0,i,j;
		//x������ʾ��ǰ��������x���꣬y������ʾ��ǰ��������y����
		int x=this.posX,y=this.posY;
		String[][] board = chessboard.getBoard();
		//���ˮƽ�������ӵĸ���
		int countl=1,lbegin=y,lend=y,lstep=y,rstep=chessboard.BOARD_SIZE-y-1;
		int mlstep=min(4,lstep);
		int mrstep=min(4,rstep);
		for(i=1;i<=mlstep;i++){
			if(board[x][y-i]=="��")
			{
				countl++;
			}
			else
				break;
		}
		lbegin=y-i+1;
		for(i=1;i<=mrstep;i++){
			if(board[x][y+i]=="��")
			{
				countl++;
			}
			else
				break;
		}
		lend=lbegin+countl-1;
		//�����ֱ�������ӵĸ���
		int countu=1,ubegin=x,uend=x;
		int ustep=x,dstep=chessboard.BOARD_SIZE-x-1;
		int mustep=min(4,ustep);
		int mdstep=min(4,dstep);
		for(i=1;i<=mustep;i++){
			if(board[x-i][y]=="��")
			{
				countu++;
			}
			else
				break;
		}
		ubegin=x-i+1;
		for(i=1;i<=mdstep;i++){
			if(board[x+i][y]=="��")
			{
				countu++;
			}
			else
				break;
		}
		uend=ubegin+countu-1;
		//������Խ������ӵĸ���
		int countlu=1,lubeginx=x,lubeginy=y,luendx=x,luendy=y;
		int lustep=min(x,y),rdstep=min(chessboard.BOARD_SIZE-x-1,chessboard.BOARD_SIZE-y-1);
		int mlustep=min(4,lustep);
		int mrdstep=min(4,rdstep);
		for(i=1;i<=mlustep;i++){
			if(board[x-i][y-i]=="��")
			{
				countlu++;
			}
			else
				break;
		}
		lubeginx=x-i+1;
		lubeginy=y-i+1;
		for(i=1;i<=mrdstep;i++){
			if(board[x+i][y+i]=="��")
			{
				countlu++;
			}
			else
				break;
		}
		luendx=lubeginx+countlu-1;
		luendy=lubeginy+countlu-1;
		//��鸱�Խ������ӵĸ���
		int countld=1,ldbeginx=x,ldbeginy=y,ldendx=x,ldendy=y;
		int ldstep=min(x,chessboard.BOARD_SIZE-y-1),rustep=min(chessboard.BOARD_SIZE-x-1,y);
		int mldstep=min(4,ldstep);
		int mrustep=min(4,rustep);
		for(i=1;i<=mldstep;i++){
			if(board[x-mldstep][y+mldstep]=="��")
			{
				countld++;
			}
			else
				break;
		}
		ldbeginx=x-i+1;
		ldbeginy=y+i+1;
		for(i=1;i<=mrustep;i++){
			if(board[x+i][y-i]=="��")
			{
				countld++;
			}
			else
				break;
		}
		ldendx=ldbeginx+countld-1;
		ldendy=ldbeginy+countld-1;
		//player���鴢����ֱ��ˮƽ�����Խ��ߣ����Խ������ӵĸ�����
		int[] player={countu,countl,countlu,countld};
		int dirindex=0;
		//�ҳ��������ӵĸ����������ͬĬ����ֱ�������Ӹ������;
		for(i=0;i<4;i++){
			if(player[i]>playercount)
			{
				playercount=player[i];
				dirindex=i;
			}
		}
		//����Ǽ������һ�����������ҵ�������������ڵ���3�����������ȶ���ң�����������������5��
		if(playercount>=3||(this.comX==-1&&this.comY==-1)){
			if(dirindex==0){
				if((ubegin-1>=0)&&(board[ubegin-1][y]=="ʮ")){
					this.comX=ubegin-1;this.comY=y;
				}
				else if((board[uend+1][y]=="ʮ")&&(uend+1<=chessboard.BOARD_SIZE-1)){
					this.comX=uend+1;this.comY=y;
				}
			}
			else if(dirindex==1){
				if((lbegin-1>=0)&&(board[x][lbegin-1]=="ʮ")){
					this.comX=x;this.comY=lbegin-1;
				}
				else if((board[x][lend+1]=="ʮ")&&(lend+1<=chessboard.BOARD_SIZE-1)){
					this.comX=x;this.comY=lend+1;
				}
			}
			else if(dirindex==2){
				if((lubeginx-1>=0)&&(lubeginy-1>=0)&&(board[lubeginx-1][lubeginy-1]=="ʮ")){
					this.comX=lubeginx-1;this.comY=lubeginy-1;
				}
				else if((board[luendx+1][luendy+1]=="ʮ")&&(luendx+1<=chessboard.BOARD_SIZE-1)&&(luendy+1<=chessboard.BOARD_SIZE-1)){
					this.comX=luendx+1;this.comY=luendy+1;
				}
			}
			else if(dirindex==3){
				if((ldbeginx-1>=0)&&(ldbeginy+1<=chessboard.BOARD_SIZE-1)&&(board[ldbeginx-1][ldbeginy+1]=="ʮ")){
					this.comX=ldbeginx-1;this.comY=ldbeginy+1;
				}
				else if((board[ldendx+1][ldendy-1]=="ʮ")&&(ldendx+1<=chessboard.BOARD_SIZE-1)&&(ldendy-1>=0)){
					this.comX=ldendx+1;this.comY=ldendy-1;
				}
		}
		}else{
			if((this.comX-1>=0)&&(board[this.comX-1][this.comY]=="ʮ")){
				this.comX=this.comX-1;this.comY=this.comY;
			}
			else if((this.comY-1>=0)&&(board[this.comX][this.comY-1]=="ʮ")){
				this.comX=this.comX;this.comY=this.comY-1;
			}
			else if((this.comY+1<=chessboard.BOARD_SIZE-1)&&(board[this.comX][this.comY+1]=="ʮ")){
				this.comX=this.comX;this.comY=this.comY+1;
			}
		}
		int[] result = { this.comX,this.comY  };
		return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public int min(int x,int y){
		return x<y?x:y;
	}
	public boolean isWon(int posX, int posY, String ico) {
		int i,j,count=0;
		String[][] board = chessboard.getBoard();
		//���ˮƽ�����Ƿ���������
		int lstep,rstep,mlstep,mrstep;//�ֱ��ʾ�󲽳����Ҳ���
		lstep=posY;rstep=chessboard.BOARD_SIZE-posY-1;
		mlstep=min(4,lstep);
		mrstep=min(4,rstep);
		for(j=posY-mlstep;j<=posY+mrstep;j++)
		{
			if(board[posX][j]==ico){
				count++;
				if(count==WIN_COUNT)
					return true;
			}
			else{
				count=0;
			}
		}
		//�����ֱ�����Ƿ���������
		int ustep,dstep,mustep,mdstep;//�ֱ��ʾ�ϲ������²���
		ustep=posX;dstep=chessboard.BOARD_SIZE-posX-1;
		mustep=min(4,ustep);
		mdstep=min(4,dstep);
		count=0;
		for(i=posX-mustep;i<=posX+mdstep;i++)
		{
			if(board[i][posY]==ico){
				count++;
				if(count==WIN_COUNT)
					return true;
			}
			else{
				count=0;
			}
		}
		//������Խ����Ƿ���������
		int lustep,rdstep,mlustep,mrdstep;//�ֱ��ʾ�ϲ������²���
		lustep=min(posX,posY);rdstep=min(chessboard.BOARD_SIZE-posX-1,chessboard.BOARD_SIZE-posY-1);
		mlustep=min(4,lustep);
		mrdstep=min(4,rdstep);
		count=0;
		for(i=-mlustep;i<=mrdstep;i++)
		{
			if(board[posX+i][posY+i]==ico){
				count++;
				if(count==WIN_COUNT)
					return true;
			}
			else{
				count=0;
			}
		}
		//��鸱�Խ����Ƿ���������
		int ldstep,rustep,mldstep,mrustep;//�ֱ��ʾ�ϲ������²���
		ldstep=min(posX,chessboard.BOARD_SIZE-posY-1);rustep=min(chessboard.BOARD_SIZE-posX-1,posY);
		mldstep=min(4,ldstep);
		mrustep=min(4,rustep);
		count=0;
		for(i=-mldstep;i<=mrustep;i++)
		{
			if(board[posX+i][posY-i]==ico){
				count++;
				if(count==WIN_COUNT)
					return true;
			}
			else{
				count=0;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
