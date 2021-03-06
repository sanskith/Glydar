package org.glydar.protocol;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Random;

import org.glydar.Server;
import org.glydar.Util;
import org.glydar.packets.Packet;

public class Version3 implements NetworkProtocol
{
	
	@Override
	public void handleIncomingPacket(Packet p)
	{
		switch (p.getId())
		{
			case 0:
				handleReadPacket0(p);
				break;
			case 6:
				handleReadPacket6(p);
				break;
			case 7:
				handleReadPacket7(p);
				break;
			case 8:
				handleReadPacket8(p);
				break;
			case 9:
				handleReadPacket9(p);
				break;
			case 10:
				handleReadPacket10(p);
				break;
			case 11:
				handleReadPacket11(p);
				break;
			case 12:
				handleReadPacket12(p);
				break;
			case 17:
				handleReadPacket17(p);
				break;
			default:
				Server.getLog().info("Unknown Packet ID! Received: " + p.getId()); //TODO Dump packet for debug
				break;
		}
		
	}
	
	@Override
	public void sendOutgoingPacket(Packet p)
	{
		//		try
		//		{
		//			Socket packSkt = p.context;
		//			DataOutputStream pout = new DataOutputStream(packSkt.getOutputStream());
		//			StringBuilder outputString = new StringBuilder();
		//			outputString.append(Integer.toHexString(p.id));
		//			outputString.append(Util.createZeros(Integer.toHexString(p.id), 8));
		//			if (p.data != null)
		//			{
		//				outputString.append(Util.byteArrayToString(p.data));
		//			}
		//			byte[] packetToSend = Util.hexStringToByteArray(outputString.toString());
		//			Server.getLog().info("Sending packet id: " + p.id + " data: " + Util.byteArrayToString(packetToSend));
		//			pout.write(packetToSend);
		//			pout.close();
		//			pout.flush();
		//		}
		//		catch (Exception ex)
		//		{
		//			
		//		}
		
	}
	
	@Override
	public void handleReadPacket0(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket6(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket7(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket8(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket9(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket10(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket11(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket12(Packet p)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleReadPacket17(Packet p)
	{
		// TODO actually handle this correctly
		// For now, we just complain that the server is full.
		//		if (new Random().nextBoolean())
		//		{
		//			handleSendPacket17(p.context);
		//		}
		//		else
		//		{
		//			handleSendPacket18(p.context);
		//		}
	}
	
	@Override
	public void handleSendPacket1(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket2(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket3(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket4(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket5(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket10(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket15(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket16(Socket context)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void handleSendPacket17(Socket context)
	{ // Version Mismatch
	
		//		Packet reply = new Packet(context);
		//		reply.id = 17;
		//		int vNum = new Random().nextInt(9001);
		//		Server.getLog().info("Random version number: " + vNum + " or " + Integer.toHexString(vNum));
		//		reply.data = Util.hexStringToByteArray(Util.createZeros(Integer.toHexString(vNum), 8) + Integer.toHexString(vNum));
		//		sendOutgoingPacket(reply);
		
	}
	
	@Override
	public void handleSendPacket18(Socket context)
	{ // Full
		//		Packet reply = new Packet(context);
		//		reply.id = 18;
		//		sendOutgoingPacket(reply);
		
	}
	
	public enum ClientPacketType
	{
		
		EntityUpdate(0), InteractPacket(6), HitPacket(7), Unknown8(8), ShootPacket(9), ClientChatMessage(10), ChunkDiscovered(11), SectorDiscovered(12), ClientVersion(17);
		
		private final int id;
		
		ClientPacketType(int id)
		{
			this.id = id;
		}
		
		public int getId()
		{
			return this.id;
		}
		
		public static ClientPacketType getPacketType(int id)
		{
			
			ClientPacketType[] types = ClientPacketType.values();
			
			for (ClientPacketType type : types)
			{
				if (type.getId() == id)
					return type;
			}
			
			return null;
			
		}
		
	}
	
	public enum ServerPacketType
	{
		
		EntityUpdate(0), MultipleEntityUpdate(1), UpdateFinished(2), Unknown3(3), Unknown4(4), CurrentTime(5), ServerChatMessage(10), SeedData(15), ServerData(16), ServerMismatch(17), ServerFull(18);
		
		private final int id;
		
		ServerPacketType(int id)
		{
			this.id = id;
		}
		
		public int getId()
		{
			return this.id;
		}
		
		public static ClientPacketType getPacketType(int id)
		{
			
			ClientPacketType[] types = ClientPacketType.values();
			
			for (ClientPacketType type : types)
			{
				if (type.getId() == id)
					return type;
			}
			
			return null;
			
		}
		
	}
	
}
