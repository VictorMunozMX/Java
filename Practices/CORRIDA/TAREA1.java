
	import java.awt.*;   
	import java.awt.event.*;   
	import javax.swing.*;   
	  
	public class PruebaMenu extends JFrame   
	{   
8.	   private final Color valoresColor[]={Color.black,Color.blue,Color.red,Color.green };   
9.	   private JRadioButtonMenuItem elementosColor[], tiposLetra[];   
10.	   private JCheckBoxMenuItem elementosEstilo[];   
11.	   private JLabel pantallaEtiqueta;   
12.	   private ButtonGroup grupoTiposLetra, grupoColores;   
13.	   private int estilo;   
14.	  
15.	   // configurar GUI   
16.	   public PruebaMenu()   
17.	   {   
18.	      super( "Uso de objetos JMenu" );        
19.	  
20.	      // establecer menú Archivo y sus elementos de menú   
21.	      JMenu menuArchivo = new JMenu( "Archivo" );   
22.	      menuArchivo.setMnemonic( 'A' );   
23.	  
24.	      // establecer elemento de menú Acerca de...   
25.	      JMenuItem elementoAcerca = new JMenuItem( "Acerca de..." );   
26.	      elementoAcerca.setMnemonic( 'c' );   
27.	      menuArchivo.add( elementoAcerca );   
28.	      elementoAcerca.addActionListener(   
29.	  
30.	         new ActionListener() {  // clase interna anónima   
31.	  
32.	            // mostrar cuadro de diálogo de mensaje cuando el usuario seleccione Acerca de...   
33.	            public void actionPerformed( ActionEvent evento )   
34.	            {   
35.	               JOptionPane.showMessageDialog( PruebaMenu.this,   
36.	                  "Éste es un ejemplo\ndel uso de menús",   
37.	                  "Acerca de", JOptionPane.PLAIN_MESSAGE );   
38.	            }   
39.	  
40.	         }  // fin de la clase interna anónima   
41.	  
42.	      ); // fin de la llamada a addActionListener   
43.	  
44.	      // establecer elemento de menú Salir   
45.	      JMenuItem elementoSalir = new JMenuItem( "Salir" );   
46.	      elementoSalir.setMnemonic( 'S' );   
47.	      menuArchivo.add( elementoSalir );   
48.	      elementoSalir.addActionListener(   
49.	  
50.	         new ActionListener() {  // clase interna anónima   
51.	  
52.	            // terminar la aplicación cuando el usuario haga clic en elementoSalir   
53.	            public void actionPerformed( ActionEvent evento )   
54.	            {   
55.	               System.exit( 0 );   
56.	            }   
57.	  
58.	         }  // fin de la clase interna anónima   
59.	  
60.	      ); // fin de la llamada a addActionListener   
61.	  
62.	      // crear barra de menús y adjuntarla a la ventana PruebaMenu   
63.	      JMenuBar barra = new JMenuBar();   
64.	      setJMenuBar( barra );   
65.	      barra.add( menuArchivo );       
66.	  
67.	      // crear menú Formato, con sus submenús y elementos de menú   
68.	      JMenu menuFormato = new JMenu( "Formato" );   
69.	      menuFormato.setMnemonic( 'F' );   
70.	  
71.	      // crear submenú Color   
72.	      String colores[] = { "Negro", "Azul", "Rojo", "Verde" };   
73.	  
74.	      JMenu menuColor = new JMenu( "Color" );   
75.	      menuColor.setMnemonic( 'C' );   
76.	  
77.	      elementosColor = new JRadioButtonMenuItem[ colores.length ];   
78.	      grupoColores = new ButtonGroup();   
79.	      ManejadorEventos manejadorEventos = new ManejadorEventos();   
80.	  
81.	      // crear elementos de menú tipo botones de opción para el menú Color   
82.	      for ( int cuenta = 0; cuenta < colores.length; cuenta++ ) {   
83.	         elementosColor[ cuenta ] =   
84.	            new JRadioButtonMenuItem( colores[ cuenta ] );   
85.	         menuColor.add( elementosColor[ cuenta ] );   
86.	         grupoColores.add( elementosColor[ cuenta ] );   
87.	         elementosColor[ cuenta ].addActionListener( manejadorEventos );   
88.	      }   
89.	  
90.	      // seleccionar primer elemento del menú Color   
91.	      elementosColor[ 0 ].setSelected( true );     
92.	  
93.	      // agregar el menú Formato a la barra de menús   
94.	      menuFormato.add( menuColor );   
95.	      menuFormato.addSeparator();   
96.	  
97.	      // crear submenú Tipo de letra   
98.	      String nombresTiposLetra[] = { "Serif", "Monospaced", "SansSerif" };   
99.	  
100.	      JMenu menuTiposLetra = new JMenu( "Tipo de letra" );   
101.	      menuTiposLetra.setMnemonic( 'T' );   
102.	  
103.	      tiposLetra = new JRadioButtonMenuItem[ nombresTiposLetra.length ];   
104.	      grupoTiposLetra = new ButtonGroup();   
105.	  
106.	      // crear elementos de menú tipo botones de opción para el menú Tipos de letra   
107.	      for ( int cuenta = 0; cuenta < tiposLetra.length; cuenta++ ) {   
108.	         tiposLetra[ cuenta ] = new JRadioButtonMenuItem( nombresTiposLetra[ cuenta ] );   
109.	         menuTiposLetra.add( tiposLetra[ cuenta ] );   
110.	         grupoTiposLetra.add( tiposLetra[ cuenta ] );   
111.	         tiposLetra[ cuenta ].addActionListener( manejadorEventos );   
112.	      }   
113.	  
114.	      // seleccionar el primer elemento del menú Tipo de letra   
115.	      tiposLetra[ 0 ].setSelected( true );   
116.	  
117.	      menuTiposLetra.addSeparator();   
118.	  
119.	      // establecer elementos del menú Estilo   
120.	      String nombresEstilo[] = { "Negrita", "Cursiva" };   
121.	  
122.	      elementosEstilo = new JCheckBoxMenuItem[ nombresEstilo.length ];   
123.	      ManejadorEstilo manejadorEstilo = new ManejadorEstilo();   
124.	  
125.	      // crear elementos de menú tipo casilla de verificación para el menú Estilo   
126.	      for ( int cuenta = 0; cuenta < nombresEstilo.length; cuenta++ ) {   
127.	         elementosEstilo[ cuenta ] =   
128.	            new JCheckBoxMenuItem( nombresEstilo[ cuenta ] );   
129.	         menuTiposLetra.add( elementosEstilo[ cuenta ] );   
130.	         elementosEstilo[ cuenta ].addItemListener( manejadorEstilo );   
131.	      }   
132.	  
133.	      // colocar menú Tipo de letra en el menú Formato   
134.	      menuFormato.add( menuTiposLetra );   
135.	  
136.	      // agregar menú Formato a la barra de menús   
137.	      barra.add( menuFormato );     
138.	  
139.	      // establecer etiqueta para mostrar texto   
140.	      pantallaEtiqueta = new JLabel( "Texto de ejemplo", SwingConstants.CENTER );   
141.	      pantallaEtiqueta.setForeground( valoresColor[ 0 ] );   
142.	      pantallaEtiqueta.setFont( new Font( "Serif", Font.PLAIN, 72 ) );   
143.	  
144.	      getContentPane().setBackground( Color.CYAN );   
145.	      getContentPane().add( pantallaEtiqueta, BorderLayout.CENTER );   
146.	  
147.	      setSize( 550, 200 );   
148.	      setVisible( true );   
149.	  
150.	   } // fin del constructor   
151.	  
152.	   public static void main( String args[] )   
153.	   {   
154.	      JFrame.setDefaultLookAndFeelDecorated(true);   
155.	      PruebaMenu aplicacion = new PruebaMenu();   
156.	      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
157.	   }   
158.	  
159.	   // clase interna para manejar eventos de acción de los elementos de menú   
160.	   private class ManejadorEventos implements ActionListener {   
161.	  
162.	      // procesar selecciones de color y tipo de letra   
163.	      public void actionPerformed( ActionEvent evento )   
164.	      {   
165.	         // procesar selección de color   
166.	         for ( int cuenta = 0; cuenta < elementosColor.length; cuenta++ )   
167.	  
168.	            if ( elementosColor[ cuenta ].isSelected() ) {   
169.	               pantallaEtiqueta.setForeground( valoresColor[ cuenta ] );   
170.	               break;   
171.	            }   
172.	  
173.	         // procesar selección de tipo de letra   
174.	         for ( int cuenta = 0; cuenta < tiposLetra.length; cuenta++ )   
175.	  
176.	            if ( evento.getSource() == tiposLetra[ cuenta ] ) {   
177.	               pantallaEtiqueta.setFont(   
178.	                  new Font( tiposLetra[ cuenta ].getText(), estilo, 72 ) );   
179.	               break;   
180.	            }   
181.	  
182.	         repaint();     
183.	  
184.	      } // fin del método actionPerformed   
185.	  
186.	   } // fin de la clase ManejadorEventos   
187.	  
188.	   // clase interna para manejar eventos de los elementos de menú tipo casilla de verificación   
189.	   private class ManejadorEstilo implements ItemListener {   
190.	  
191.	      // procesar selecciones de estilo de tipo de letra   
192.	      public void itemStateChanged( ItemEvent e )   
193.	      {   
194.	         estilo = 0;   
195.	  
196.	         // checar selección de negrita   
197.	         if ( elementosEstilo[ 0 ].isSelected() )   
198.	            estilo += Font.BOLD;   
199.	  
200.	         // checar selección de cursiva   
201.	         if ( elementosEstilo[ 1 ].isSelected() )   
202.	            estilo += Font.ITALIC;   
203.	  
204.	         pantallaEtiqueta.setFont(   
205.	            new Font( pantallaEtiqueta.getFont().getName(), estilo, 72 ) );   
206.	  
207.	         repaint();   
208.	      }   
209.	  
210.	   } // fin de la clase ManejadorEstilo   
211.	  
212.	} // fin de la clase PruebaMenu  
