import java.io.*;
class Hotel
{
	//�\��󋵂��i�[����ϐ� (0���󎺁@1�������j
	int reservation[][] = new int[4][4];
	
	//�\��󋵂�\�����郁�\�b�h�y�������z��@Y���ɊK�AX���ɕ����ԍ��z
	void show()	
	{	
		System.out.println("������������������������������������������������������������������");
		System.out.println("�@�y��:�󎺁@�~:�����z");
	
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{	
				if(reservation[i][j]==0)
				{	System.out.print((i+1)+"0"+(j+1)+"����");
					System.out.print("�@�@���@�@");
				}
				else
				{	System.out.print((i+1)+"0"+(j+1)+"����");
					System.out.print("�@�@�~�@�@");
				}
			}
			System.out.println("");
		}
		System.out.println("������������������������������������������������������������������\n");
	}
	
	//�����̒l�i��\�����郁�\�b�h�@�i���ϐ�������Ȃ��ꍇ�́A����for���Ǝg���ĉ񂳂Ȃ��悤�ɂ���B�j
	//
	void price()
	{		
			System.out.println("���y�����\�z��������������������������������������");
			System.out.println("1F�̕����i101�`104�����j�y���а   �z�F1��\\ 50,000");
			System.out.println("2F�̕����i201�`204�����j�y����ް�ށz�F1��\\100,000");
			System.out.println("3F�̕����i301�`304�����j�y�ް�ެ� �z�F1��\\300,000");
			System.out.println("4F�̕����i401�`404�����j�yV.I.P   �z�F1��\\500,000");
			System.out.println("��������������������������������������������������\n");
	}
	
	//�\�񃁃\�b�h (�������ɓ����Ă��������񂩂當�������o���A���̌㕶���𕶎���ɂ��Ă���A����ɐ��l�ɕύX���đ������z���Y����X���փ}�C�i�X�P�����Ă��܂��킹�����Ă��ꂼ��i�[�I�j
	void setRes(String r)
	{
	   char f = r.charAt(0); 
	   char e = r.charAt(2);
	
	//�����̃N���X���C�u�����ł����������Ȃ������₷��B
	//��String Substring�̃N���X���C�u�������g���BString�^�̂܂܂Ŏg���� ����O��������ĂȂ���ԁ�
	
	//�������z��ԍ��i�m�F�p�F�j���Ƃŏ����I
	//System.out.println(f+e+"���������z��ԍ��i�m�F�p�F�j���Ƃŏ����I");
	
	
		//1�������͂��ꂽ�ꍇ�A1�ԖڂƍŌ�̕��������o���Ȃ����߁A�G���[�����B
		int Floor =Integer.parseInt(""+f);
		int Room  =Integer.parseInt(""+e);
		
		if(reservation[Floor-1][Room-1]==0)
		{	reservation[Floor-1][Room-1]=1;
			System.out.println("�\�񂪊������܂����B������肵�Ă��Ă�(^--^#)");
		}
		else
		{
			System.out.println("���߁`��B������˂񂩁I���̕����ɂ��Ă���ւ�H");
		}
	}
	//�\��L�����Z�����\�b�h
	void cancelRes(String r)	
	{
	   char f = r.charAt(0); 
	   char e = r.charAt(2);
	
		int Floor =Integer.parseInt(""+f);
		int Room  =Integer.parseInt(""+e);
		
		if(reservation[Floor-1][Room-1]==1)
		{	reservation[Floor-1][Room-1]=0;
			System.out.println("�\����L�����Z�����܂����B�܂����Ă�(^--^#)");
		}
		else
		{
			System.out.println("�󎺂ł��B���\�񂳂ꂽ�����ԍ������m���߂��������I");
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
			System.out.println("\n��������������������������������");
			System.out.println("�������y�S�[�W���X�z�e���z������");
			System.out.println("��������������������������������\n");
			System.out.println("�`��������Ⴂ�܂��`��(���P(�G)�P��)��y-�K�K");
			System.out.println("�����őI�����Ă˂�");
			System.out.println("1..�\�񂷂�@2..�󂫕����m�F�@3..�L�����Z���@0.�I���i�����A��I�j");
		
			String str =br.readLine();
			res =Integer.parseInt(str);
		
			switch(res)
			{
				case 0:
				System.out.println("�܂��̂��z�������҂����Ă���܂��B(�܁ށ�)���Ȱ!! ");
				break;
				
				case 1:
								
				int roop;
				
				do{
				h.price();
				h.show();
							
				System.out.println("�h����������������3���̐����݂̂őI��ł�(^--^#)�I");
				System.out.println("��j303�����̏ꍇ�́A�u303�v�ƃL�[�{�[�h������͂�Enter�L�[�������ĂˁV�P��)�U");
				str =br.readLine();
								
				String room =str;
				h.setRes(room);
				
				//do while�ŉ񂷁Bwhile�̌�́i������True�ɂ��Ă����āAdo�@while�̒��ɁAif����g��ŁAif��true�̎���
				//���[�v�𔲂��镶�ɂ����ق��������B
				
				roop =Integer.parseInt(room);
				
				}while(roop<101||roop>404);
				
				break;
				
				case 2:
				h.show();
				break;
				
				case 3:
				h.price();
				h.show();
				
				System.out.println("�\����L�����Z���������������̔ԍ���3���̐����݂̂őI��ł�(^--^#)�I");
				System.out.println("��j202�����̏ꍇ�́A�u202�v�ƃL�[�{�[�h������͂�Enter�L�[�������ĂˁV�P��)�U");
				str =br.readLine();
				String room =str;
				h.cancelRes(room);
				break;
				
				default:
				System.out.println("0�`3�̐��������Ă�");
				break;
			}
		
		}while(res!=0);
	}
}
		