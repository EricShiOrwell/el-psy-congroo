package 魔王語言;
import java.util.*;

public class 魔王语言 {
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
		case 't':System.out.print("天");break;
		case 'd':System.out.print("地");break;
		case 's':System.out.print("上");break;
		case 'a':System.out.print("一只");break;
		case 'e':System.out.print("鹅");break;
		case 'z':System.out.print("追");break;
		case 'g':System.out.print("赶");break;
		case 'x':System.out.print("下");break;
		case 'n':System.out.print("蛋");break;
		case 'h':System.out.print("恨");break;
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
