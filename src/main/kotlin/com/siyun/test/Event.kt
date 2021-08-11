package com.siyun.test

import com.destroystokyo.paper.event.player.PlayerConnectionCloseEvent
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.event.player.PlayerSwapHandItemsEvent
import org.bukkit.inventory.ItemStack


class Event : Listener {
    @Suppress("DEPRECATION")
    @EventHandler
    fun join(e: PlayerJoinEvent) {
        val p = e.player
        e.joinMessage = "§a   [+]   §f${p.name}가 §6§l'환장의 복어 서버'§f에 들어왔다!!"
    }


    @Suppress("DEPRECATION")
    @EventHandler
    fun quit(e: PlayerQuitEvent) {
        val p = e.player
        e.quitMessage = "§c   [-]   §f${p.name}가 §6§l'환장의 복어 서버'§f를 나갔어.."
    }


    @Suppress("DEPRECATION")
    @EventHandler
    open fun menu(e: PlayerSwapHandItemsEvent) {
        val p = e.player
        if (p.isSneaking) {
            e.isCancelled = true
            val inv = Bukkit.createInventory(null, 27, "메뉴")


            /*val i1 = ItemStack(Material.COOKIE)
            val i1meta = i1.itemMeta
            i1meta.setDisplayName("§6쿠키")
            i1meta.lore = arrayListOf("§f맛있는 쿠키..인가?.","§f맛있는 쿠키인거같은데?","§f겁나 맛있고 달달할듯?!.","","§e클릭시 확인합니다.")
            i1.itemMeta = i1meta
            inv.setItem(13, i1)*/

            val lore = arrayListOf("§f맛있는 쿠키..인가?.", "§f맛있는 쿠키인거같은데?", "§f겁나 맛있고 달달할듯?!.", "", "§e클릭시 확인합니다.")
            val item1 = Util.guiitem(Material.COOKIE, 1, "§6쿠키", lore, 1)
            inv.setItem(13, item1)

            val list = arrayListOf(3,4,5,12,14,21,22,23)
            val itemDeco = Util.guiitem(Material.WHITE_STAINED_GLASS_PANE, 1, "§o", arrayListOf("",""), 1)
            for (n in list){
                inv.setItem(n, itemDeco)
            }
            p.openInventory(inv)


        }

        @Suppress("DEPRECATION")
        @EventHandler
        fun invclick(e: InventoryClickEvent) {
            val p = e.whoClicked
            if (e.view.title==("메뉴")) {
                e.isCancelled = true
            }
        }
    }
}





