import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatIntelliJLaf;

import presentation.Vue.VueConnexion;

import presentation.Models.*;
import presentation.Controleur.*;
import presentation.Vue.*;

public class Test {

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new FlatIntelliJLaf());
        new ControleurLogin().afficheLogin();
	}

}
