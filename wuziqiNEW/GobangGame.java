import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		//playercount用来表示当前玩家的最大连子数，computercount用来表示当前计算机的最大连子数
		int playercount=0,conputercount=0,i,j;
		//x用来表示当前玩家下棋的x坐标，y用来表示当前玩家下棋的y坐标
		int x=this.posX,y=this.posY;
		String[][] board = chessboard.getBoard();
		//检查水平方向连子的个数
		int countl=1,lbegin=y,lend=y,lstep=y,rstep=chessboard.BOARD_SIZE-y-1;
		int mlstep=min(4,lstep);
		int mrstep=min(4,rstep);
		for(i=1;i<=mlstep;i++){
			if(board[x][y-i]=="●")
			{
				countl++;
			}
			else
				break;
		}
		lbegin=y-i+1;
		for(i=1;i<=mrstep;i++){
			if(board[x][y+i]=="●")
			{
				countl++;
			}
			else
				break;
		}
		lend=lbegin+countl-1;
		//检查竖直方向连子的个数
		int countu=1,ubegin=x,uend=x;
		int ustep=x,dstep=chessboard.BOARD_SIZE-x-1;
		int mustep=min(4,ustep);
		int mdstep=min(4,dstep);
		for(i=1;i<=mustep;i++){
			if(board[x-i][y]=="●")
			{
				countu++;
			}
			else
				break;
		}
		ubegin=x-i+1;
		for(i=1;i<=mdstep;i++){
			if(board[x+i][y]=="●")
			{
				countu++;
			}
			else
				break;
		}
		uend=ubegin+countu-1;
		//检查主对角线连子的个数
		int countlu=1,lubeginx=x,lubeginy=y,luendx=x,luendy=y;
		int lustep=min(x,y),rdstep=min(chessboard.BOARD_SIZE-x-1,chessboard.BOARD_SIZE-y-1);
		int mlustep=min(4,lustep);
		int mrdstep=min(4,rdstep);
		for(i=1;i<=mlustep;i++){
			if(board[x-i][y-i]=="●")
			{
				countlu++;
			}
			else
				break;
		}
		lubeginx=x-i+1;
		lubeginy=y-i+1;
		for(i=1;i<=mrdstep;i++){
			if(board[x+i][y+i]=="●")
			{
				countlu++;
			}
			else
				break;
		}
		luendx=lubeginx+countlu-1;
		luendy=lubeginy+countlu-1;
		//检查副对角线连子的个数
		int countld=1,ldbeginx=x,ldbeginy=y,ldendx=x,ldendy=y;
		int ldstep=min(x,chessboard.BOARD_SIZE-y-1),rustep=min(chessboard.BOARD_SIZE-x-1,y);
		int mldstep=min(4,ldstep);
		int mrustep=min(4,rustep);
		for(i=1;i<=mldstep;i++){
			if(board[x-mldstep][y+mldstep]=="●")
			{
				countld++;
			}
			else
				break;
		}
		ldbeginx=x-i+1;
		ldbeginy=y+i+1;
		for(i=1;i<=mrustep;i++){
			if(board[x+i][y-i]=="●")
			{
				countld++;
			}
			else
				break;
		}
		ldendx=ldbeginx+countld-1;
		ldendy=ldbeginy+countld-1;
		int[] player={countu,countl,countlu,countld};
		int dirindex=0;
		for(i=0;i<4;i++){
			if(player[i]>playercount)
			{
				playercount=player[i];
				dirindex=i;
			}
		}
		
		if(playercount>=3||(this.comX==-1&&this.comY==-1)){
			if(dirindex==0){
				if((ubegin-1>=0)&&(board[ubegin-1][y]=="十")){
					this.comX=ubegin-1;this.comY=y;
				}
				else if((board[uend+1][y]=="十")&&(uend+1<=chessboard.BOARD_SIZE-1)){
					this.comX=uend+1;this.comY=y;
				}
			}
			else if(dirindex==1){
				if((lbegin-1>=0)&&(board[x][lbegin-1]=="十")){
					this.comX=x;this.comY=lbegin-1;
				}
				else if((board[x][lend+1]=="十")&&(lend+1<=chessboard.BOARD_SIZE-1)){
					this.comX=x;this.comY=lend+1;
				}
			}
			else if(dirindex==2){
				if((lubeginx-1>=0)&&(lubeginy-1>=0)&&(board[lubeginx-1][lubeginy-1]=="十")){
					this.comX=lubeginx-1;this.comY=lubeginy-1;
				}
				else if((board[luendx+1][luendy+1]=="十")&&(luendx+1<=chessboard.BOARD_SIZE-1)&&(luendy+1<=chessboard.BOARD_SIZE-1)){
					this.comX=luendx+1;this.comY=luendy+1;
				}
			}
			else if(dirindex==3){
				if((ldbeginx-1>=0)&&(ldbeginy+1<=chessboard.BOARD_SIZE-1)&&(board[ldbeginx-1][ldbeginy+1]=="十")){
					this.comX=ldbeginx-1;this.comY=ldbeginy+1;
				}
				else if((board[ldendx+1][ldendy-1]=="十")&&(ldendx+1<=chessboard.BOARD_SIZE-1)&&(ldendy-1>=0)){
					this.comX=ldendx+1;this.comY=ldendy-1;
				}
		}
		}else{
			if((this.comX-1>=0)&&(board[this.comX-1][this.comY]=="十")){
				this.comX=this.comX-1;this.comY=this.comY;
			}
			else if((this.comY-1>=0)&&(board[this.comX][this.comY-1]=="十")){
				this.comX=this.comX;this.comY=this.comY-1;
			}
			else if((this.comY+1<=chessboard.BOARD_SIZE-1)&&(board[this.comX][this.comY+1]=="十")){
				this.comX=this.comX;this.comY=this.comY+1;
			}
		}
		int[] result = { this.comX,this.comY  };
		return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		// 直线起点的X坐标
		int startX = 0;
		// 直线起点Y坐标
		int startY = 0;
		// 直线结束X坐标
		int endX = Chessboard.BOARD_SIZE - 1;
		// 直线结束Y坐标
		int endY = endX;
		// 同条直线上相邻棋子累积数
		int sameCount = 0;
		int temp = 0;

		// 计算起点的最小X坐标与Y坐标
		temp = posX - WIN_COUNT + 1;
		startX = temp < 0 ? 0 : temp;
		temp = posY - WIN_COUNT + 1;
		startY = temp < 0 ? 0 : temp;
		// 计算终点的最大X坐标与Y坐标
		temp = posX + WIN_COUNT - 1;
		endX = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
		: temp;
		temp = posY + WIN_COUNT - 1;
		endY = temp > Chessboard.BOARD_SIZE - 1 ? Chessboard.BOARD_SIZE - 1
		: temp;
		// 从左到右方向计算相同相邻棋子的数目
		String[][] board = chessboard.getBoard();
		for (int i = startY; i < endY; i++) {
		if (board[posX][i] == ico && board[posX][i + 1] == ico) {
		sameCount++;
		} else if (sameCount != WIN_COUNT - 1) {
		sameCount = 0;
		}
		}
		if (sameCount == 0) {
		// 从上到下计算相同相邻棋子的数目
		for (int i = startX; i < endX; i++) {
		if (board[i][posY] == ico && board[i + 1][posY] == ico) {
		sameCount++;
		} else if (sameCount != WIN_COUNT - 1) {
		sameCount = 0;
		}
		}
		}
		if (sameCount == 0) {
		// 从左上到右下计算相同相邻棋子的数目
		int j = startY;
		for (int i = startX; i < endX; i++) {
		if (j < endY) {
		if (board[i][j] == ico && board[i + 1][j + 1] == ico) {
		sameCount++;
		} else if (sameCount != WIN_COUNT - 1) {
		sameCount = 0;
		}
		j++;
		}
		}
		}
		return sameCount == WIN_COUNT - 1 ? true : false;
		}
	


	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
