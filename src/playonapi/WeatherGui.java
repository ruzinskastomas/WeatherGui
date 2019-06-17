/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playonapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author marius
 */
public class WeatherGui extends javax.swing.JFrame {

    /**
     * Creates new form WeatherGui
     */
    public WeatherGui() {
        initComponents();
        getWeather();
    }

    public int getWeather() {
        int code = 0;
        String urlofget;
        if (country.getText().equals("")) {
            String address = "https://api.openweathermap.org/data/2.5/forecast/daily?q=London&appid=ae3723984918e29156906ffa2182bf02";
            urlofget = address;
            CountryName.setText("London");
        } else {
            String address = "https://api.openweathermap.org/data/2.5/forecast/daily?q=" + country.getText() + "&appid=ae3723984918e29156906ffa2182bf02";
            urlofget = address;
            CountryName.setText(country.getText());
        }
        try {

            URL url = new URL(urlofget);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15 * 1000);
            connection.setRequestMethod("GET");
            connection.connect();
            code = connection.getResponseCode();
            if (code == 200) {
                GetDayOfWeek getday = new GetDayOfWeek();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(content);
                JsonToMap gson = new JsonToMap();
                int i = 0;
                double deg;
                String degrees;
                while (i <= 6) {
                    //creating a full list of contents
                    Map<String, Object> resultMap = gson.jsonToMap(content.toString());
                    //making list smaller and getting list's object values..
                    ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) resultMap.get("list");
                    Map<String, Object> listMap = list.get(i);
                    //Getting temp object's values.
                    Map<String, Object> temps = (Map<String, Object>) listMap.get("temp");
                    //Creating an arraylist for the weather array which is in list object.
                    ArrayList<Map<String, Object>> weathers = (ArrayList<Map<String, Object>>) listMap.get("weather");
                    Map<String, Object> weatherMap = weathers.get(0);
                    Map<String, Object> city = (Map<String, Object>) resultMap.get("city");
                    Calendar c = Calendar.getInstance();
                    c.getTime();
                    //days 1 - 7
                    if (i == 0) {
                        deg = (Double) temps.get("day") - 273.15;
                        degrees = String.valueOf((int) deg);
                        maindeg.setText(degrees + "°");
                        main1.setText((String) weatherMap.get("main"));
                        desc1.setText((String) weatherMap.get("description"));
                        day1.setText(getday.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
                    }
                    if (i == 1) {
                        deg = (Double) temps.get("day") - 273.15;
                        degrees = String.valueOf((int) deg);
                        deg2.setText(degrees + "°");
                        main2.setText((String) weatherMap.get("main"));
                        desc2.setText((String) weatherMap.get("description"));
                        c.add(Calendar.DAY_OF_MONTH, 1);
                        day2.setText(getday.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
                    }
                    if (i == 2) {
                        deg = (Double) temps.get("day") - 273.15;
                        degrees = String.valueOf((int) deg);
                        deg3.setText(degrees + "°");
                        main3.setText((String) weatherMap.get("main"));
                        desc3.setText((String) weatherMap.get("description"));
                        c.add(Calendar.DAY_OF_MONTH, 2);
                        day3.setText(getday.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
                    }
                    if (i == 3) {
                        deg = (Double) temps.get("day") - 273.15;
                        degrees = String.valueOf((int) deg);
                        deg4.setText(degrees + "°");
                        main4.setText((String) weatherMap.get("main"));
                        desc4.setText((String) weatherMap.get("description"));
                        c.add(Calendar.DAY_OF_MONTH, 3);
                        day4.setText(getday.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
                    }
                    if (i == 4) {
                        deg = (Double) temps.get("day") - 273.15;
                        degrees = String.valueOf((int) deg);
                        deg5.setText(degrees + "°");
                        main5.setText((String) weatherMap.get("main"));
                        desc5.setText((String) weatherMap.get("description"));
                        c.add(Calendar.DAY_OF_MONTH, 4);
                        day5.setText(getday.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
                    }
                    if (i == 5) {
                        deg = (Double) temps.get("day") - 273.15;
                        degrees = String.valueOf((int) deg);
                        deg6.setText(degrees + "°");
                        main6.setText((String) weatherMap.get("main"));
                        desc6.setText((String) weatherMap.get("description"));
                        c.add(Calendar.DAY_OF_MONTH, 5);
                        day6.setText(getday.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));
                    }
                    i++;

                }
                in.close();
            } else {
                System.out.println("Please enter a valid country");
            }
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return code;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        maindeg = new javax.swing.JLabel();
        country = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        day2 = new javax.swing.JLabel();
        deg2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        day6 = new javax.swing.JLabel();
        deg6 = new javax.swing.JLabel();
        main6 = new javax.swing.JLabel();
        desc6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        day5 = new javax.swing.JLabel();
        deg5 = new javax.swing.JLabel();
        main5 = new javax.swing.JLabel();
        desc5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        day4 = new javax.swing.JLabel();
        deg4 = new javax.swing.JLabel();
        main4 = new javax.swing.JLabel();
        desc4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        day3 = new javax.swing.JLabel();
        deg3 = new javax.swing.JLabel();
        main3 = new javax.swing.JLabel();
        desc3 = new javax.swing.JLabel();
        main2 = new javax.swing.JLabel();
        desc2 = new javax.swing.JLabel();
        CountryName = new javax.swing.JLabel();
        day1 = new javax.swing.JLabel();
        main1 = new javax.swing.JLabel();
        desc1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        maindeg.setFont(new java.awt.Font("Bookman Old Style", 0, 36)); // NOI18N
        maindeg.setForeground(new java.awt.Color(255, 255, 255));
        maindeg.setText("Error");
        getContentPane().add(maindeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 240, 90));

        country.setToolTipText("Enter a country to display weather information");
        country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryActionPerformed(evt);
            }
        });
        getContentPane().add(country, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, 460, 20));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        day2.setForeground(new java.awt.Color(255, 255, 255));
        day2.setText("Error");
        jPanel1.add(day2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        deg2.setForeground(new java.awt.Color(255, 255, 255));
        deg2.setText("Error");
        jPanel1.add(deg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 70, 40));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        day6.setForeground(new java.awt.Color(255, 255, 255));
        day6.setText("Error");

        deg6.setForeground(new java.awt.Color(255, 255, 255));
        deg6.setText("Error");

        main6.setForeground(new java.awt.Color(255, 255, 255));
        main6.setText("main");

        desc6.setForeground(new java.awt.Color(255, 255, 255));
        desc6.setText("desc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(main6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deg6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(day6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addComponent(desc6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(day6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(main6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(desc6, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deg6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 100, 280));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        day5.setForeground(new java.awt.Color(255, 255, 255));
        day5.setText("Error");

        deg5.setForeground(new java.awt.Color(255, 255, 255));
        deg5.setText("Error");

        main5.setForeground(new java.awt.Color(255, 255, 255));
        main5.setText("main");

        desc5.setForeground(new java.awt.Color(255, 255, 255));
        desc5.setText("desc");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(main5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deg5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(day5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addComponent(desc5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(day5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(main5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(desc5, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deg5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 100, 280));

        jPanel4.setBackground(new java.awt.Color(153, 255, 102));

        day4.setForeground(new java.awt.Color(255, 255, 255));
        day4.setText("Error");

        deg4.setForeground(new java.awt.Color(255, 255, 255));
        deg4.setText("Error");

        main4.setForeground(new java.awt.Color(255, 255, 255));
        main4.setText("main");

        desc4.setForeground(new java.awt.Color(255, 255, 255));
        desc4.setText("desc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deg4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(day4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(main4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(day4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(main4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(desc4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deg4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 100, 280));

        jPanel5.setBackground(new java.awt.Color(255, 153, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        day3.setForeground(new java.awt.Color(255, 255, 255));
        day3.setText("Error");

        deg3.setForeground(new java.awt.Color(255, 255, 255));
        deg3.setText("Error");

        main3.setForeground(new java.awt.Color(255, 255, 255));
        main3.setText("main");

        desc3.setForeground(new java.awt.Color(255, 255, 255));
        desc3.setText("desc");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desc3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(main3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(deg3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(day3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(day3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(main3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(desc3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deg3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 100, 280));

        main2.setForeground(new java.awt.Color(255, 255, 255));
        main2.setText("Main");
        jPanel1.add(main2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, 30));

        desc2.setForeground(new java.awt.Color(255, 255, 255));
        desc2.setText("desc");
        desc2.setToolTipText("");
        jPanel1.add(desc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 130));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 490, 280));

        CountryName.setFont(new java.awt.Font("Bookman Old Style", 0, 36)); // NOI18N
        CountryName.setForeground(new java.awt.Color(255, 255, 255));
        CountryName.setText("Please Enter a Valid Country");
        getContentPane().add(CountryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 530, 80));

        day1.setFont(new java.awt.Font("Bookman Old Style", 0, 36)); // NOI18N
        day1.setForeground(new java.awt.Color(255, 255, 255));
        day1.setText("Day");
        getContentPane().add(day1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 330, 90));

        main1.setFont(new java.awt.Font("Bookman Old Style", 0, 36)); // NOI18N
        main1.setForeground(new java.awt.Color(255, 255, 255));
        main1.setText("Main1");
        getContentPane().add(main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 240, 70));

        desc1.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        desc1.setForeground(new java.awt.Color(255, 255, 255));
        desc1.setText("Desc1");
        getContentPane().add(desc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 240, 120));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\marius\\Downloads\\blue-soft-abstract-background-loopable_4jajpisbg__F0000.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 1020, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryActionPerformed

    }//GEN-LAST:event_countryActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        getWeather();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CountryName;
    private javax.swing.JTextField country;
    private javax.swing.JLabel day1;
    private javax.swing.JLabel day2;
    private javax.swing.JLabel day3;
    private javax.swing.JLabel day4;
    private javax.swing.JLabel day5;
    private javax.swing.JLabel day6;
    private javax.swing.JLabel deg2;
    private javax.swing.JLabel deg3;
    private javax.swing.JLabel deg4;
    private javax.swing.JLabel deg5;
    private javax.swing.JLabel deg6;
    private javax.swing.JLabel desc1;
    private javax.swing.JLabel desc2;
    private javax.swing.JLabel desc3;
    private javax.swing.JLabel desc4;
    private javax.swing.JLabel desc5;
    private javax.swing.JLabel desc6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel main1;
    private javax.swing.JLabel main2;
    private javax.swing.JLabel main3;
    private javax.swing.JLabel main4;
    private javax.swing.JLabel main5;
    private javax.swing.JLabel main6;
    private javax.swing.JLabel maindeg;
    // End of variables declaration//GEN-END:variables
}
