/* метод дихотомии, метод Ньютона, метод секущих, метод простой итерации */

package mna_4;

import static java.lang.Math.*;


public class Main {
	 public static void DichotomyMethod()
	    {
	        System.out.println("Метод дихотомии \n");
	        double a = 1.4, b=2;
	        double xk = (a+b)/2;
	        double x0 = (a+b)/2;
	        double fxk;
	        double eps = 0.1;
	        double ak=a, bk=b;
	        double fak;
	        int iter = 0;
	        double temp;

	        while(abs(bk-ak)>=2*eps)
	        {
	            iter++;
	            fxk=pow(4,xk)-5*xk-2;
	            fak=pow(4,ak)-5*ak-2;
	            if (fxk*fak<0)
	                bk=xk;
	            else
	                ak=xk;

	            xk=(ak+bk)/2;
	            temp = abs(x0-xk);
	            System.out.println("|xk-x0| :"  +temp+"\n");

	        }
	        System.out.println("Ответ  "+xk);
	        System.out.println("Количество итераций  "+iter);
	        System.out.println("\n\n\n");
	    }

	     public static  void NewtonMethod()
	     {
	         System.out.println("Метод Ньютона");
	         double x0=1.7;
	         double temp=10;
	         double eps = pow(10,-7);
	         //double xk;
	         double iter = 0;
	         while(temp>eps)
	         {
	             double xk;
	             double f=pow(4,x0)-5*x0-2;
	             double df = log(4)*pow(4,x0)-5;
	             xk=x0-f/df;
	             temp = abs(xk-x0);
	             iter++;
	             x0=xk;
	             System.out.println("|xk-x0| :"  +temp+"\n");
	         }
	         System.out.println("Ответ  "+x0);
	         System.out.println("Количество итераций  "+iter);
	         System.out.println("\n\n\n");

	     }

	     public static void SecantConverges()
	     {
	         double a = 1.6, b=1.8;

	         double fa=pow(4,a)-5*a-2;
	         double fb=pow(4,b)-5*b-2;
	         double fafb = fa*fb;

	         double c = (a+b)/2;
	         double fc = pow(4,c)-5*c-2;

	         boolean method = false;


	         if ((fa<0)&&(fc>0))
	             method = true;
	         if ((fa>0)&&(fc<0))
	             method = true;

	         if ((fb<0)&&(fc>0))
	             method = true;
	         if ((fb>0)&&(fc<0))
	             method = true;

	         if (fafb <0)
	             method=true;
	         else
	             method=false;


	         if (method)
	             System.out.println("Метод Секущих сходится \n");
	         else
	             System.out.println("Метод Секущих расходится \n");

	     }

	     public static void IterationConverges()
	     {
	         double a = 1.6, b=1.8;
	         double x0=(a+b)/2;
	         double phi=log(5*x0+2)/log(4);
	         double dphi=5/(log(4)*(5*x0+2));
	         double delta = (b-a)/2;
	         double q = abs(dphi);
	         double ddphi=(-25)/(log(4)*pow((5*x0+2),2));
	         double m=abs(ddphi);
	         boolean method = false;

	         if ((q<1))
	             method=true;
	         else
	             method=false;

	         if (m/(1-q)<=delta)
	             method = true;
	         else
	             method= false;

	         if(abs(x0-phi)<=m)
	             method = true;
	         else
	             method= false;

	         if (method)
	             System.out.println("МПИ сходится \n");
	         else
	             System.out.println("МПИ расходится \n");
	     }

	     public static void IterationMethod()
	     {
	         System.out.println("Метод простой итерации");
	         double x0=1.7;
	         double temp=10;
	         double eps = pow(10,-7);
	         double iter = 0;
	         double xk=x0;
	         while(temp>eps)
	         {
	             x0=xk;
	             xk=log(5*x0+2)/log(4);
	             System.out.println(xk);
	             temp = abs(x0-xk);
	             iter++;


	             System.out.println("|xk-x0| :"  +temp+"\n");
	         }
	         System.out.println("Ответ  "+x0);
	         System.out.println("Количество итераций  "+iter);
	         System.out.println("\n\n\n");

	     }

	     public static void SecantMethod()
	     {
	         System.out.println("Метод секущих");
	         double x0=1.7;
	         double x00=1.8;
	         double f0=pow(4,x0)-5*x0-2;//f00 и f0 два предыдущих шага
	         double f00=pow(4,x00)-5*x00-2;
	         double temp=10;
	         double eps = pow(10,-7);
	         double iter = 0;
	         double xk=x0;
	         while(temp>eps)
	         {

	             xk=x0-((x0-x00)/(f0-f00))*f0;
	             System.out.println(xk);
	             temp = abs(x0-xk);
	             iter++;
	             x00=x0;
	             x0=xk;


	             System.out.println("|xk-x0| :"  +temp+"\n");
	         }
	         System.out.println("Ответ  "+x0);
	         System.out.println("Количество итераций  "+iter);
	         System.out.println("\n\n\n");
	     }

	    public static void main(String[] args)
	    {

	        DichotomyMethod();
	        NewtonMethod();
	        IterationConverges();
	        IterationMethod();
	        SecantConverges();
	        SecantMethod();

	    }

}
