package vinsetspiritueux.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Method;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import vinsetspiritueux.ctrl.Controller;

/**
 * Classe représentant la vue de l'application MVC "VinsEtSpiritueux" du module D400.
 *
 * @author <a href="mailto:paul.friedli@edufr.ch">Paul Friedli</a>
 * @since 08.12.2023
 * @version 1.1.0
 */
public class View extends javax.swing.JFrame {

    /**
     * Constructeur de la classe View. Ce constructeur crée la vue, l'initialise correctement et mais ne l'affiche pas
     * encore.
     */
    public View() {

        // Initialiser TOUS nos attributs
        this.refCtrl = null;

        // Dire à Java de faire ressembler cette application à celles de la plateforme sur laquelle il est en train de tourner.
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
        } catch ( Exception e ) {
        }

        initComponents();

        // Notre  ne peut  être redimensionnée.
        setResizable( false );
        setMinimumSize( new Dimension( getWidth(), getHeight() ) );
        setMaximumSize( new Dimension( getWidth(), getHeight() ) );

        // Code spécial pour avoir un icône d'application sur le dock de Max OS/X
        try {
            // Définir l'icône de l'application.
            setIconImage( new ImageIcon( getClass().getResource( "resources/bottles.png" ) ).getImage() );
            // <editor-fold defaultstate="collapsed" desc="Code pour avoir l'icône sur le Dock pour OS/X">                          
            // Et sur Mac, l'icône utilisée dans le Dock, mais de manière dynamique puisque cette classe n'est peut-être pas disponible (sur Windows)
            {
                try {
                    Class aClass = Class.forName( "com.apple.eawt.Application" );
                    Method getApplication = aClass.getMethod( "getApplication", ( Class[] ) null );
                    Object application = getApplication.invoke( null );
                    Method setDockIconImage = aClass.getMethod( "setDockIconImage", Image.class );
                    Image appIcon = new ImageIcon( getClass().getResource( "resources/bottles.png" ) ).getImage();
                    setDockIconImage.invoke( application, appIcon );
                } catch ( Exception e ) {
                }
            }
// </editor-fold>               
        } catch ( Exception e ) {
        }

        // Définir le titre de l'application
        setTitle( "Gestion de vin v1.0 - Écrit par Paul Friedli" );

        // Ne pas fermer la fenêtre automatiquement, nous appellerons dispose() nous-même.
        setDefaultCloseOperation( javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE );

        // Centrer la fenêtre à l'écran
        setLocationRelativeTo( null );

        // S'assurer qu'on soit informé lorsque l'utilisateur voudra quitter cette fenêtre
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing( WindowEvent we ) {
                // Signalons au contrôleur que l'utilisateur veut quitter.
                viewExiting();
            }
        } );
    }

    /**
     * Rend visible la vue à l'écran.
     */
    public void viewStart() {
        setVisible( true );
    }

    /**
     * Cette méthode permet d'afficher un message d'information à l'utilisateur.
     *
     * @param message le message d'information à afficher
     */
    public void messageInformation( String message ) {
        ImageIcon informationIcon = new ImageIcon( getClass().getResource( "ressources/icon-fine-64.png" ) );
        JOptionPane.showMessageDialog( this, message, "Information", JOptionPane.INFORMATION_MESSAGE, informationIcon );
    }

    /**
     * Cette méthode permet d'afficher un message d'erreur à l'utilisateur.
     *
     * @param message le message d'erreur à afficher
     */
    public void messageErreur( String message ) {
        ImageIcon warningIcon = new ImageIcon( getClass().getResource( "ressources/icon-error-64.png" ) );
        JOptionPane.showMessageDialog( this, message, "Information", JOptionPane.INFORMATION_MESSAGE, warningIcon );
    }

    /**
     * Cette méthode permet d'afficher une question de type oui/non à l'utilisateur.
     *
     * @param question la question à afficher dont la réponse doit être de type oui/non
     *
     * @return vrai pour oui
     */
    public boolean messageQuestion( String question ) {
        ImageIcon questionIcon = new ImageIcon( getClass().getResource( "ressources/icon-question-64.png" ) );
        return ( JOptionPane.showConfirmDialog( getRootPane(), question, "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon ) == JOptionPane.YES_OPTION );
    }

    ///////////////////////////////////////////////////////////////////////////
    // Méthodes internes (privées)
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Cette méthode est appelée pour indiquer que l'application est en train de se fermer. Cela permet d'informer le
     * contrôleur de cet état de fait.
     */
    private void viewExiting() {
        ImageIcon questionIcon = new ImageIcon( getClass().getResource( "ressources/icon-question-64.png" ) );
        if ( JOptionPane.showConfirmDialog( getRootPane(), "Voulez-vous vraiment quitter ?", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, questionIcon ) == JOptionPane.YES_OPTION ) {
            // Informer le contrôleur qu'on veut quitter
            getRefCtrl().viewExiting();

            // Arrêter ce qui doit être arrêté côté de la vue (timer, threads, ..)
            // rien à faire...
            // Fermer la vue
            dispose();
        }
    }

    /**
     * Getter de la référence au contrôleur de l'application.
     *
     * @return la référence au contrôleur de l'application
     */
    public Controller getRefCtrl() {
        return refCtrl;
    }

    /**
     * Setter de la référence au contrôleur de l'application.
     *
     * @param ctrl la nouvelle référence au contrôleur de l'application
     */
    public void setRefCtrl( Controller ctrl ) {
        this.refCtrl = ctrl;
    }

    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAfficherTout = new javax.swing.JButton();
        jButtonAfficherStatistiques = new javax.swing.JButton();
        jButtonAfficherValeurStock = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonQuitter = new javax.swing.JButton();
        jLabelSwissSoftwareLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelEntreprises = new javax.swing.JPanel();
        jButtonChargerEntrepriseA = new javax.swing.JButton();
        jButtonChargerEntrepriseB = new javax.swing.JButton();
        jButtonChargerEntrepriseC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButtonAfficherTout.setText("Afficher tout (locaux + armoires + contenu)");
        jButtonAfficherTout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficherToutActionPerformed(evt);
            }
        });

        jButtonAfficherStatistiques.setText("Afficher statistiques (locaux et armoires)");
        jButtonAfficherStatistiques.setActionCommand("Afficher statistiques de chaque local");
        jButtonAfficherStatistiques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficherStatistiquesActionPerformed(evt);
            }
        });

        jButtonAfficherValeurStock.setText("Afficher valeur totale du stock");
        jButtonAfficherValeurStock.setActionCommand("Afficher statistiques de chaque armoire");
        jButtonAfficherValeurStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAfficherValeurStockActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/search_64.png"))); // NOI18N
        jLabel1.setText("Actions");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAfficherValeurStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAfficherStatistiques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAfficherTout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAfficherTout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAfficherStatistiques)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAfficherValeurStock)
                .addContainerGap())
        );

        jButtonQuitter.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jButtonQuitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/door-32.png"))); // NOI18N
        jButtonQuitter.setText("Quitter");
        jButtonQuitter.setToolTipText("Pour quitter l'application");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabelSwissSoftwareLogo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSwissSoftwareLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSwissSoftwareLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/swiss-made-software.png"))); // NOI18N
        jLabelSwissSoftwareLogo.setToolTipText("Battons-nous pour la qualité !");
        jLabelSwissSoftwareLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabelSwissSoftwareLogo.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/bottles.png"))); // NOI18N
        jLabel3.setText("<html>Gestion de vins&nbsp;&nbsp;<div align=\"right\"><font size=\"2\" color=\"gray\" face=\"Arial\">Écrit par Paul FRIEDLI, Copyright © 2021&nbsp;&nbsp;</font></div></html>");

        jPanelEntreprises.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jButtonChargerEntrepriseA.setText("Charger situation Entreprise A");
        jButtonChargerEntrepriseA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargerEntrepriseAActionPerformed(evt);
            }
        });

        jButtonChargerEntrepriseB.setText("Charger situation Entreprise B");
        jButtonChargerEntrepriseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargerEntrepriseBActionPerformed(evt);
            }
        });

        jButtonChargerEntrepriseC.setText("Charger situation Entreprise C");
        jButtonChargerEntrepriseC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChargerEntrepriseCActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("ressources/factory_64.png"))); // NOI18N
        jLabel2.setText("Entreprises");

        javax.swing.GroupLayout jPanelEntreprisesLayout = new javax.swing.GroupLayout(jPanelEntreprises);
        jPanelEntreprises.setLayout(jPanelEntreprisesLayout);
        jPanelEntreprisesLayout.setHorizontalGroup(
            jPanelEntreprisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEntreprisesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEntreprisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonChargerEntrepriseC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonChargerEntrepriseB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonChargerEntrepriseA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEntreprisesLayout.setVerticalGroup(
            jPanelEntreprisesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEntreprisesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonChargerEntrepriseA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonChargerEntrepriseB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonChargerEntrepriseC)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelEntreprises, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonQuitter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSwissSoftwareLogo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonQuitter)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelEntreprises, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelSwissSoftwareLogo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAfficherToutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficherToutActionPerformed
        getRefCtrl().actionAfficherTout();
    }//GEN-LAST:event_jButtonAfficherToutActionPerformed

    private void jButtonAfficherStatistiquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficherStatistiquesActionPerformed
        getRefCtrl().actionAfficherStatistiques();
    }//GEN-LAST:event_jButtonAfficherStatistiquesActionPerformed

    private void jButtonAfficherValeurStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAfficherValeurStockActionPerformed
        getRefCtrl().actionAfficherValeurStock();
    }//GEN-LAST:event_jButtonAfficherValeurStockActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        viewExiting();
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jButtonChargerEntrepriseAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargerEntrepriseAActionPerformed
        getRefCtrl().actionChargerEntrepriseA();
    }//GEN-LAST:event_jButtonChargerEntrepriseAActionPerformed

    private void jButtonChargerEntrepriseBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargerEntrepriseBActionPerformed
        getRefCtrl().actionChargerEntrepriseB();
    }//GEN-LAST:event_jButtonChargerEntrepriseBActionPerformed

    private void jButtonChargerEntrepriseCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChargerEntrepriseCActionPerformed
        getRefCtrl().actionChargerEntrepriseC();
    }//GEN-LAST:event_jButtonChargerEntrepriseCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAfficherStatistiques;
    private javax.swing.JButton jButtonAfficherTout;
    private javax.swing.JButton jButtonAfficherValeurStock;
    private javax.swing.JButton jButtonChargerEntrepriseA;
    private javax.swing.JButton jButtonChargerEntrepriseB;
    private javax.swing.JButton jButtonChargerEntrepriseC;
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSwissSoftwareLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEntreprises;
    // End of variables declaration//GEN-END:variables

    /**
     * La référence au contrôleur de l'application.
     */
    private Controller refCtrl;
}
