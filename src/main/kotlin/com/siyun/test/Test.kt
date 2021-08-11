package com.siyun.test

import net.citizensnpcs.api.scripting.EventRegistrar
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Test : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(Event(), this)
        Bukkit.getLogger().info("§e[환장의 복어 서버]")
    }

    override fun onDisable() {
        server.pluginManager.registerEvents(Event(), this)
    }
}





