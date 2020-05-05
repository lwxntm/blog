package com.github.lwxntm.blog

import com.github.kotlintelegrambot.bot

class TelegramHandler {
    fun sendMessage(str: String) {
        sendMessage("1157776609:AAEBXoaOA7RRI-T0yYtj0T4yN7UPlt9RZcI", 628620014, str)
    }

    fun sendMessage(chatId: Long, str: String) {
        sendMessage("1157776609:AAEBXoaOA7RRI-T0yYtj0T4yN7UPlt9RZcI", chatId, str)
    }

    fun sendMessage(botApi: String, chatId: Long, str: String) {
        val bot = bot {
            token = botApi
        }
        bot.sendMessage(chatId = chatId, text = str)
    }

}
