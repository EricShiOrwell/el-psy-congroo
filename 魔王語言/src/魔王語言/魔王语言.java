package ħ���Z��;
import java.util.*;

public class ħ������ {
    static int rulepanding=0;
    static char abc;
 
	public static void main(String[] args) {
		
		Scanner out=new Scanner(System.in);
		Sy_zhan language1=new Sy_zhan(10);
		Sy_zhan language2=new Sy_zhan(20);
		char[] flag=out.nextLine().toCharArray();
		language1.equal(flag);
		while(!language1.empty()){
			rule(language1.pop(),language1,language2);
		}
		while((abc=language2.read())!='0'){
		switch (abc) {
		case 't':System.out.print("��");break;
		case 'd':System.out.print("��");break;
		case 's':System.out.print("��");break;
		case 'a':System.out.print("һֻ");break;
		case 'e':System.out.print("��");break;
		case 'z':System.out.print("׷");break;
		case 'g':System.out.print("��");break;
		case 'x':System.out.print("��");break;
		case 'n':System.out.print("��");break;
		case 'h':System.out.print("��");break;
		default:break;
		}
		}
		
		
	}
	static void rule(char a,Sy_zhan e,Sy_zhan f){
		if(a==')'){
			rulepanding=1;
			mark(e);
			return;
		};
		if(a=='('){
			rulepanding=0;
			f.pop();
			return;
		}
		if(rulepanding==1){
			f.push(abc);
			f.push(a);
		}
		else{
			if(a=='B'){
				f.push('t');
				f.push('s');
				f.push('a');
				f.push('e');
				f.push('d');
				f.push('s');
				f.push('a');
				f.push('e');
			}
			else if(a=='A'){
				f.push('s');
				f.push('a');
				f.push('d');
			}
		}
		
		
	}
	static void mark(Sy_zhan e){
		abc=e.zhiding(e.search('(')+1);
		
	}
	

}
