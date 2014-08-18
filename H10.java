import java.io.*;
class Hotel
{
	//予約状況を格納する変数 (0→空室　1→満室）
	int reservation[][] = new int[4][4];
	
	//予約状況を表示するメソッド【多次元配列　Y軸に階、X軸に部屋番号】
	void show()	
	{	
		System.out.println("¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
		System.out.println("　【○:空室　×:満室】");
	
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{	
				if(reservation[i][j]==0)
				{	System.out.print((i+1)+"0"+(j+1)+"号室");
					System.out.print("　　○　　");
				}
				else
				{	System.out.print((i+1)+"0"+(j+1)+"号室");
					System.out.print("　　×　　");
				}
			}
			System.out.println("");
		}
		System.out.println("¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n");
	}
	
	//部屋の値段を表示するメソッド　（※変数が入らない場合は、特にfor文と使って回さないようにする。）
	//
	void price()
	{		
			System.out.println("¶【料金表】¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
			System.out.println("1Fの部屋（101～104号室）【ｴｺﾉﾐｰ   】：1泊\\ 50,000");
			System.out.println("2Fの部屋（201～204号室）【ｽﾀﾝﾀﾞｰﾄﾞ】：1泊\\100,000");
			System.out.println("3Fの部屋（301～304号室）【ｺﾞｰｼﾞｬｽ 】：1泊\\300,000");
			System.out.println("4Fの部屋（401～404号室）【V.I.P   】：1泊\\500,000");
			System.out.println("¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶\n");
	}
	
	//予約メソッド (仮引数に入ってきた文字列から文字を取り出し、その後文字を文字列にしてから、さらに数値に変更して多次元配列のY軸とX軸へマイナス１をしてつじつまあわせをしてそれぞれ格納！）
	void setRes(String r)
	{
	   char f = r.charAt(0); 
	   char e = r.charAt(2);
	
	//↑他のクラスライブラリでいいやり方がないか質問する。
	//◆String Substringのクラスライブラリを使う。String型のままで使える ※例外処理入れてない状態◆
	
	//多次元配列番号（確認用：）あとで消す！
	//System.out.println(f+e+"←多次元配列番号（確認用：）あとで消す！");
	
	
		//1文字入力された場合、1番目と最後の文字が取り出せないため、エラー発生。
		int Floor =Integer.parseInt(""+f);
		int Room  =Integer.parseInt(""+e);
		
		if(reservation[Floor-1][Room-1]==0)
		{	reservation[Floor-1][Room-1]=1;
			System.out.println("予約が完了しました。ゆっくりしてってね(^--^#)");
		}
		else
		{
			System.out.println("ごめ～ん。満室やねんか！他の部屋にしてくれへん？");
		}
	}
	//予約キャンセルメソッド
	void cancelRes(String r)	
	{
	   char f = r.charAt(0); 
	   char e = r.charAt(2);
	
		int Floor =Integer.parseInt(""+f);
		int Room  =Integer.parseInt(""+e);
		
		if(reservation[Floor-1][Room-1]==1)
		{	reservation[Floor-1][Room-1]=0;
			System.out.println("予約をキャンセルしました。またきてね(^--^#)");
		}
		else
		{
			System.out.println("空室です。ご予約された部屋番号をお確かめください！");
		}
	}
}

class H10
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br =
		 new BufferedReader(new InputStreamReader(System.in));
		
		Hotel h =new Hotel();
		
	
		int res;
		
		do
		{
			System.out.println("\n‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡");
			System.out.println("‡‡‡【ゴージャスホテル】‡‡‡");
			System.out.println("‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡‡\n");
			System.out.println("～いらっしゃいませ～⊂(●￣(エ)￣●)⊃y-゜゜");
			System.out.println("数字で選択してねっ");
			System.out.println("1..予約する　2..空き部屋確認　3..キャンセル　0.終了（もう帰る！）");
		
			String str =br.readLine();
			res =Integer.parseInt(str);
		
			switch(res)
			{
				case 0:
				System.out.println("またのお越しをお待ちしております。(⌒∇⌒)ﾉﾏﾀﾈｰ!! ");
				break;
				
				case 1:
								
				int roop;
				
				do{
				h.price();
				h.show();
							
				System.out.println("宿泊したいお部屋を3桁の数字のみで選んでね(^--^#)！");
				System.out.println("例）303号室の場合は、「303」とキーボードから入力しEnterキーを押してね〃￣∇)ゞ");
				str =br.readLine();
								
				String room =str;
				h.setRes(room);
				
				//do whileで回す。whileの後は（条件をTrueにしておいて、do　whileの中に、if文を組んで、ifがtrueの時に
				//ループを抜ける文にしたほうがいい。
				
				roop =Integer.parseInt(room);
				
				}while(roop<101||roop>404);
				
				break;
				
				case 2:
				h.show();
				break;
				
				case 3:
				h.price();
				h.show();
				
				System.out.println("予約をキャンセルしたいお部屋の番号を3桁の数字のみで選んでね(^--^#)！");
				System.out.println("例）202号室の場合は、「202」とキーボードから入力しEnterキーを押してね〃￣∇)ゞ");
				str =br.readLine();
				String room =str;
				h.cancelRes(room);
				break;
				
				default:
				System.out.println("0～3の数字を入れてね");
				break;
			}
		
		}while(res!=0);
	}
}
		