package externalauthenticate;

import java.util.List;
import javax.smartcardio.*;

public class CanalTarjeta 
{
	public CardChannel canal;
	
	public CanalTarjeta()
	{
		canal = obtenerCanal(obtenerLector());		
	}
	
	private CardTerminal obtenerLector()
	{
		try
		{
			TerminalFactory factory = TerminalFactory.getDefault();
			//TerminalFactory factory = TerminalFactory.;
			List<CardTerminal> listaTerminales = factory.terminals().list();			
			CardTerminal terminal = listaTerminales.get(0);
			//CardTerminal terminal = factory.terminals().getTerminal("Arygon Multi-ISO 000000000100010E 0");
			System.out.println("Lector: " + terminal.getName());
			return terminal;		
		}		
		catch(Exception e)
		{
			System.out.println(e.getMessage() + "...Obtener CardTerminal");
			return null;
		}		
	}
	
	private CardChannel obtenerCanal(CardTerminal Lector)
	{
		try
		{
			Card tarjeta = Lector.connect("T=0");
			CardChannel canal = tarjeta.getBasicChannel();
			return canal;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + "...Obtener canal");
			return null;
		}
		
	}
	
	public String envioComando(String comando, CardChannel canal)
	{
		byte[] bytes = HexStringToByteArray(comando);
		CommandAPDU comandoAPDU = new CommandAPDU(bytes);
		try
		{
			ResponseAPDU respuestaAPDU = canal.transmit(comandoAPDU);			
			byte[] data = respuestaAPDU.getData();	
			if(data.length != 0)
				return arrayToHex(data);
			else
				return respuestaAPDU.toString();			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+ " (EnvioComando)");
			return "Exception en envioComando";
		}
	}
	
	private  byte[] HexStringToByteArray(String s) 
	{     
		Integer b = 0;
		byte data[] = new byte[s.length()/2];     
		for(int i=0;i < s.length();i+=2) 
		{         
			b = (Integer.decode("0x"+s.charAt(i)+s.charAt(i+1)));				
			data[i/2] = b.byteValue();			
		}     
		return data; 
	}
	
	private String arrayToHex(byte[] data) 
	{
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++) 
        {
            String bs = Integer.toHexString(data[i] & 0xFF);
            if (bs.length() == 1) 
            {
                sb.append(0);
            }
            sb.append(bs);
        }
        return sb.toString();
    }
}
