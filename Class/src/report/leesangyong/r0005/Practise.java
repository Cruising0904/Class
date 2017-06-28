package report.leesangyong.r0005;

public class Practise {
public static void main(String[]args){
	char a = 'a'; // ' 작은따옴표로 문자인식???
	char d = 'd';
	char zero = '0';
	char two = '2';
	
	System.out.printf("'%c'-'%c'=%d%n",d, a, d - a); //'d'='a'=3
	System.out.printf("'%c'-'%c'=%d%n",two, zero, two - zero); 
	System.out.printf("'%c'=%d%n", a, (int)a); 
	System.out.printf("'%c'=%d%n", a, (int)d); 
	System.out.printf("'%c'=%d%n",zero,(int)zero); 
	System.out.printf("'%c'=%d%n",two,(int)two); 
}
}
