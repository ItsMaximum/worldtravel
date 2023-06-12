package com.maximum.worldtravel;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;


public class GameListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {

        /*
        Player p = e.getPlayer();
        p.setInvisible(true);
        p.setAllowFlight(true);
        p.setFlying(true);
        p.setCollidable(false);

        CraftPlayer craftPlayer = (CraftPlayer) p;
        ServerPlayer serverPlayer = craftPlayer.getHandle();

        FriendlyByteBuf fbb = new FriendlyByteBuf(Unpooled.buffer());
        fbb.writeVarInt(serverPlayer.getId());
        fbb.writeDouble(p.getLocation().getX());
        fbb.writeDouble(p.getLocation().getY() + 2);
        fbb.writeDouble(p.getLocation().getZ());
        fbb.writeByte(0);
        fbb.writeByte(0);
        fbb.writeBoolean(false);

        ClientboundTeleportEntityPacket packet = new ClientboundTeleportEntityPacket(fbb);

        serverPlayer.connection.send(packet);
        */
        
    /*
    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        CraftPlayer craftPlayer = (CraftPlayer) p;
        ServerPlayer serverPlayer = craftPlayer.getHandle();

        World world = p.getWorld();

        org.bukkit.entity.ArmorStand joever = (org.bukkit.entity.ArmorStand) world.spawnEntity(new Location(world, 56, 90, 14, 0, 45), EntityType.ARMOR_STAND);
        joever.setInvisible(true);
        ArmorStand armorStand = ((CraftArmorStand) joever).getHandle();

        //ClientboundAddEntityPacket entityPacket = new ClientboundAddEntityPacket(armorStand);
        ClientboundSetCameraPacket cameraPacket = new ClientboundSetCameraPacket(armorStand);
        
        
        //serverPlayer.connection.send(entityPacket);
        serverPlayer.connection.send(cameraPacket);
        

        new BukkitRunnable() {
            private byte yaw = 0;

            private double radius = 2; // Radius of the circle
            private double speed = 0.05; // Speed of movement
            private double angle = 0.0; // Current angle

            @Override
            public void run() {
                
                // Calculate the new velocity based on the angle
                double x = radius * Math.cos(angle);
                double z = radius * Math.sin(angle); 

                float floatYaw = (float) ((angle * (180 / Math.PI)));
                byte byteYaw = (byte) (floatYaw * 256 / 360);

                //armorStand.setPos(56 + x, 90, 14 + z);
                //armorStand.setDeltaMovement(x, 0, z);
                joever.setVelocity(new Vector(x, 0, z));
                //armorStand.setDeltaMovement(x, 0, z);
                //armorStand.setYHeadRot(floatYaw);
                ClientboundRotateHeadPacket rotHeadPacket = new ClientboundRotateHeadPacket(armorStand, byteYaw);
                
                
                //Rot rotPacket = new Rot(armorStand.getBukkitEntity().getEntityId(), byteYaw, (byte) 0, false);
                //Pos posPacket = new Pos(armorStand.getBukkitEntity().getEntityId(), (short) x, (short) 0, (short) z, false);

                serverPlayer.connection.send(rotHeadPacket);
                //serverPlayer.connection.send(posPacket);
                

                //serverPlayer.connection.send(rotPacket);
                //serverPlayer.connection.send(posPacket);

                // Increment the angle for the next iteration
                angle += speed;
            }
        }.runTaskTimer(Main.getInstance(), 0L, 1L);
    }
    */
    }
}
