
package websocket.server;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class Thread1 extends Thread
{
    
  Random rand = new Random(); 
  private static final DecimalFormat df2 = new DecimalFormat("#.##");
      
    @Override
    public void run()
    {
        while(true)
        {
            double usdToInr = rand.nextDouble()+68.5; 
            double sellUsd=usdToInr+0.1;
            String roundedSellUsd=df2.format(sellUsd);
            double buyUsd=usdToInr-0.1;
            String roundedBuyUsd=df2.format(buyUsd);
            
           
            double eurToInr = rand.nextDouble()+77; 
            double sellEur=eurToInr+0.1;
            String roundedSellEur=df2.format(sellEur);
            double buyEur=eurToInr-0.1;
            String roundedBuyEur=df2.format(buyEur);


            double jpyToInr = rand.nextDouble()+0.2; 
            double sellJpy=jpyToInr+0.1;
            String roundedSellJpy=df2.format(sellJpy);
            double buyJpy=jpyToInr-0.1;
            String roundedBuyJpy=df2.format(buyJpy);

            
            double hkdToInr = rand.nextDouble()+8.5; 
            double sellHkd=hkdToInr+0.1;
            String roundedSellHkd=df2.format(sellHkd);
            double buyHkd=hkdToInr-0.1;
            String roundedBuyHkd=df2.format(buyHkd);
                       
            
            //JSON..........................USD
            StringBuffer inputUsd = new StringBuffer("{");
            inputUsd.append("\"SellingPriceUsd\":");
            inputUsd.append(roundedSellUsd);
            inputUsd.append(",");
            inputUsd.append("\"BuyingPriceUsd\":");
            inputUsd.append(roundedBuyUsd);
            inputUsd.append("}");
             
            String stringUsd=inputUsd.toString();
            
            
             //JSON..........................EUR
            StringBuffer inputEur = new StringBuffer("{");
            inputEur.append("\"SellingPriceEur\":");
            inputEur.append(roundedSellEur);
            inputEur.append(",");
            inputEur.append("\"BuyingPriceEur\":");
            inputEur.append(roundedBuyEur);
            inputEur.append("}");
             
            String stringEur=inputEur.toString();
           
            
            //JSON..........................JPY
            StringBuffer inputJpy = new StringBuffer("{");
            inputJpy.append("\"SellingPriceJpy\":");
            inputJpy.append(roundedSellJpy);
            inputJpy.append(",");
            inputJpy.append("\"BuyingPriceJpy\":");
            inputJpy.append(roundedBuyJpy);
            inputJpy.append("}");
             
            String stringJpy=inputJpy.toString();
           
            
             //JSON..........................HKD
            StringBuffer inputHkd = new StringBuffer("{");
            inputHkd.append("\"SellingPriceHkd\":");
            inputHkd.append(roundedSellHkd);
            inputHkd.append(",");
            inputHkd.append("\"BuyingPriceHkd\":");
            inputHkd.append(roundedBuyHkd);
            inputHkd.append("}");
             
            String stringHkd=inputHkd.toString();
            
            try {
                //sending all json string to custom end point send all method
                CustomEndPoint.sendAll(stringUsd,stringEur,stringJpy,stringHkd);
            } catch (IOException ex) { }
           
            try {
                 Thread.sleep(2000);
                } catch (Exception e) {
                System.out.println(e);
            }
             
        }
    }
}
