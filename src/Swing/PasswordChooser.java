package Swing;

import javax.swing.*;
import java.awt.*;
import entity.User;
/**
 * A password chooser that is shown inside a dialog.
 */
public class PasswordChooser extends JPanel
{
   private JTextField username;
   private JTextField userType;

   private JButton okButton;
   private boolean ok;
   private JDialog dialog;

   public PasswordChooser()
   {
      setLayout(new BorderLayout());

      // construct a panel with user name and password fields

      var panel = new JPanel();
      panel.setLayout(new GridLayout(3, 2));
      panel.add(new JLabel("User name:"));
      panel.add(username = new JTextField(""));
      panel.add(new JLabel("User Type:"));
      panel.add(userType = new JTextField(""));


      add(panel, BorderLayout.CENTER);

      // create Ok and Cancel buttons that terminate the dialog

      okButton = new JButton("登陆");
      okButton.addActionListener(event -> {
         ok = true;
         dialog.setVisible(false);
      });

      var cancelButton = new JButton("注册");
      cancelButton.addActionListener(event -> {
         dialog.setVisible(false);
      });

      // add buttons to southern border

      var buttonPanel = new JPanel();
      buttonPanel.add(okButton);
      buttonPanel.add(cancelButton);
      add(buttonPanel, BorderLayout.SOUTH);
   }

   /**
    * Sets the dialog defaults.
    * @param u the default user information
    */
   public void setUser(User u)
   {
      username.setText(u.getUserName());
   }

   /**
    * Gets the dialog entries.
    * @return a User object whose state represents the dialog entries
    */
   public User getUser()
   {
      return new User(username.getText(), userType.getText());
   }

   /**
    * Show the chooser panel in a dialog.
    * @param parent a component in the owner frame or null
    * @param title the dialog window title
    */
   public boolean showDialog(Component parent, String title)
   {
      ok = false;

      // locate the owner frame

      Frame owner = null;
      if (parent instanceof Frame)
         owner = (Frame) parent;
      else
         owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

      // if first time, or if owner has changed, make new dialog

      if (dialog == null || dialog.getOwner() != owner)
      {
         dialog = new JDialog(owner, true);
         dialog.add(this);
         dialog.getRootPane().setDefaultButton(okButton);
         dialog.pack();
      }

      // set title and show dialog

      dialog.setTitle(title);
      dialog.setVisible(true);
      return ok;
   }
}
