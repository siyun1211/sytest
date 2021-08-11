package com.siyun.test

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Util {
    companion object {
        fun guiitem(m: Material, q: Int ,name: String, lore: List<String>, md: Int): ItemStack {
            val item = ItemStack(m, q)
            val meta = item.itemMeta
            meta.setDisplayName(name)
            meta.lore = lore
            meta.setCustomModelData(md)
            item.itemMeta = meta
            return item
        }
    }
}