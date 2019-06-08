package com.wenner.github.bean






data class Word (
    var word_name: String,
    var is_CRI: String,
    var exchange: Exchange,
    var symbols: Any,
    var items: Any
) {
    data class Exchange(
        var word_pl: Any,
        var word_done: Any,
        var word_ing: Any,
        var word_third: Any,
        var word_er: Any,
        var word_est: Any
    )

    data class Symbols(
        var ph_en: String,
        var ph_am: String,
        var ph_other: String,
        var ph_en_mp3: String,
        var ph_am_mp3: String,
        var ph_tts_mp3: String,
        var parts: Any

    ) {
        data class Part(
            var part: String,
            var means: Any
        )

    }
}
