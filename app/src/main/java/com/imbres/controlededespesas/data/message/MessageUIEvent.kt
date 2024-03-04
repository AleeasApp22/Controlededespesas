package com.imbres.controlededespesas.data.message

sealed class MessageUIEvent{
    object MessageButtonClicked : MessageUIEvent()
}
