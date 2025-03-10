// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

class Currency_Converter$1 implements ActionListener {
   Currency_Converter$1(Currency_Converter var1) {
      this.this$0 = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      try {
         double var2 = Double.parseDouble(this.this$0.amountField.getText());
         String var4 = (String)this.this$0.fromComboBox.getSelectedItem();
         String var5 = (String)this.this$0.toComboBox.getSelectedItem();
         double var6 = this.this$0.exchangeRates[this.this$0.getIndex(var5)] / this.this$0.exchangeRates[this.this$0.getIndex(var4)];
         double var8 = var2 * var6;
         JLabel var10000 = this.this$0.resultLabel;
         String var10001 = this.this$0.decimalFormat.format(var8);
         var10000.setText(var10001 + " " + var5);
      } catch (Exception var10) {
         this.this$0.resultLabel.setText("Invalid input");
      }

   }
}
