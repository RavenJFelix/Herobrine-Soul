package soul.soulclient;

import soul.soulclient.SoulClient;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;
import soul.util.wrapper.MinecraftWrapper;
public class HerobrineListener implements Runnable
{
	private Socket herobrineConnection;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private SoulClient soulClient;

	public HerobrineListener(Socket hostSocket, SoulClient soulClient) throws IOException
	{
		herobrineConnection = hostSocket;
		dataInputStream = new DataInputStream(herobrineConnection.getInputStream());
		dataOutputStream = new DataOutputStream(herobrineConnection.getOutputStream());
		this.soulClient = soulClient;
	}

	@Override
	public void run()
	{
		for(;;)//For hardcore sake yeee
		{
			try
			{
				String command = dataInputStream.readUTF();
				soulClient.proccessCommand(command);
			}
			catch(IOException e)
			{
				break;
			}
		}

	}
}
