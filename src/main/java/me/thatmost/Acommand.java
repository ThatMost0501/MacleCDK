package me.thatmost;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class Acommand implements CommandExecutor {
    public static maclecdk a = maclecdk.getIns();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 0) {
            if (p.hasPermission("maclecdk.admin")){
                p.sendMessage("§a===========================maclecdk===========================");
                p.sendMessage("§9/maclecdk create [command] [num]    创建[num]个执行[command]命令的CDK");
                p.sendMessage("§9/maclecdk export                    批量一键导出所有CDK");
                p.sendMessage("§9/maclecdk reload                    重载配置文件");
                p.sendMessage("§9/maclecdk [CDK]                     使用CDK");
                p.sendMessage("§a===========================maclecdk===========================");
            }else {
                p.sendMessage("§a===========================maclecdk===========================");
                p.sendMessage("§9/maclecdk [CDK]                     使用CDK");
                p.sendMessage("§a===========================maclecdk===========================");
            }
        }else if (args[0].equalsIgnoreCase("create") && p.hasPermission("maclecdk.admin")){
            if (args.length >=3){
                int num = Integer.parseInt(args[args.length - 1]);
                for (int i = 0; i < num; i++){
                    String key = GetCDK.getCDK();
                    maclecdk.getIns().getConfig().set(key + ".command", getCommand(args));
                    maclecdk.getIns().getConfig().set(key + ".op", true);
                    maclecdk.getIns().saveConfig();
                }
                p.sendMessage("§6设置成功！成功创建§c " + num + " §6张卡密, 详情请浏览配置文件");
            }else {
                p.sendMessage("§4参数不足！");
            }
        }else if (args.length == 1){
            if (args[0].equalsIgnoreCase("reload") && p.hasPermission("maclecdk.admin")){
                a.reloadConfig();
                a.saveConfig();
                p.sendMessage("§6配置文件重载成功！");
                return true;
            }
            if (args[0].equalsIgnoreCase("export") && p.hasPermission("maclecdk.admin")){
                try {
                    if (exportCDK()){
                        p.sendMessage("§6导出成功！请检查配置文件中export.yml");
                    }else {
                        p.sendMessage("§c在导出过程中发生错误！请检查！");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
            String input = args[0];
            for (String li : maclecdk.getIns().getConfig().getKeys(false)){
                if (input.equals(li)){
                    boolean resp = runCDK(li, p);
                    if (resp){
                        a.getConfig().set(li, null);
                        a.saveConfig();
                        p.sendMessage("§6命令执行成功！");
                    }
                    return true;
                }
            }
            p.sendMessage("§4CDK不存在！");
        }else {
            p.sendMessage("§4指令是不是打错了？？？");
        }
        return true;
    }
    private static String getCommand(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= strs.length - 2; i++){
            result.append(strs[i]).append(" ");
        }
        return result.toString();
    }
    private static boolean runCDK(String cdk, Player player) {
        boolean result;
        String command = a.getConfig().getString(cdk + ".command").replace("{player}", player.getName());
        if (maclecdk.getIns().getConfig().getBoolean(cdk + ".op")){
            result = Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }else {
            result = player.performCommand(command);
        }
        return result;
    }
    private static boolean exportCDK() throws IOException {
        Set<String> cdkList = maclecdk.getIns().getConfig().getKeys(false);
        int i = 1;
        for (String cdk : cdkList) {
            String path = maclecdk.getIns().getConfig().getString(cdk + ".command");
            maclecdk.filec.set(path + "." + i, cdk);
            maclecdk.filec.save(maclecdk.getIns().file);
            i ++;
        }
        return true;
    }
    private static void setLog(String cdk, Player user) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        maclecdk.uselog.set(cdk + ".user", user.getName());
        maclecdk.uselog.set(cdk + ".time", formatter.format(date));
        maclecdk.uselog.save(maclecdk.getIns().used);
    }
}
