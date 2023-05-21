package ru.runx.lempact.dto.yt

/**
 * Ratings schemes. The country-specific ratings are mostly for movies and shows. LINT.IfChange
 */
data class ContentRating(
    /**
     * The video's Australian Classification Board (ACB) or Australian Communications and Media
     * Authority (ACMA) rating. ACMA ratings are used to classify children's television programming.
     * The value may be `null`.
     */
    val acbRating: String? = null,
    /**
     * The video's rating from Italy's Autorità per le Garanzie nelle Comunicazioni (AGCOM).
     * The value may be `null`.
     */
    @com.google.api.client.util.Key
    val agcomRating: String? = null,
    /**
     * The video's Anatel (Asociación Nacional de Televisión) rating for Chilean television.
     * The value may be `null`.
     */
    val anatelRating: String? = null,
    /**
     * The video's British Board of Film Classification (BBFC) rating.
     * The value may be `null`.
     */
    val bbfcRating: String? = null,
    /**
     * The video's rating from Thailand's Board of Film and Video Censors.
     * The value may be `null`.
     */
    val bfvcRating: String? = null,
    /**
     * The video's rating from the Austrian Board of Media Classification (Bundesministerium für
     * Unterricht, Kunst und Kultur).
     * The value may be `null`.
     */
    val bmukkRating: String? = null,
    /**
     * Rating system for Canadian TV - Canadian TV Classification System The video's rating from the
     * Canadian Radio-Television and Telecommunications Commission (CRTC) for Canadian English-
     * language broadcasts. For more information, see the Canadian Broadcast Standards Council
     * website.
     * The value may be `null`.
     */
    val catvRating: String? = null,
    /**
     * The video's rating from the Canadian Radio-Television and Telecommunications Commission (CRTC)
     * for Canadian French-language broadcasts. For more information, see the Canadian Broadcast
     * Standards Council website.
     * The value may be `null`.
     */
    val catvfrRating: String? = null,
    /**
     * The video's Central Board of Film Certification (CBFC - India) rating.
     * The value may be `null`.
     */
    val cbfcRating: String? = null,
    /**
     * The video's Consejo de Calificación Cinematográfica (Chile) rating.
     * The value may be `null`.
     */
    val cccRating: String? = null,
    /**
     * The video's rating from Portugal's Comissão de Classificação de Espect´culos.
     * The value may be `null`.
     */
    val cceRating: String? = null,
    /**
     * The video's rating in Switzerland.
     * The value may be `null`.
     */
    val chfilmRating: String? = null,
    /**
     * The video's Canadian Home Video Rating System (CHVRS) rating.
     * The value may be `null`.
     */
    val chvrsRating: String? = null,
    /**
     * The video's rating from the Commission de Contrôle des Films (Belgium).
     * The value may be `null`.
     */
    val cicfRating: String? = null,
    /**
     * The video's rating from Romania's CONSILIUL NATIONAL AL AUDIOVIZUALULUI (CNA).
     * The value may be `null`.
     */
    val cnaRating: String? = null,
    /**
     * Rating system in France - Commission de classification cinematographique
     * The value may be `null`.
     */
    val cncRating: String? = null,
    /**
     * The video's rating from France's Conseil supérieur de l’audiovisuel, which rates broadcast
     * content.
     * The value may be `null`.
     */
    val csaRating: String? = null,
    /**
     * The video's rating from Luxembourg's Commission de surveillance de la classification des films
     * (CSCF).
     * The value may be `null`.
     */
    val cscfRating: String? = null,
    /**
     * The video's rating in the Czech Republic.
     * The value may be `null`.
     */
    val czfilmRating: String? = null,
    /**
     * The video's Departamento de Justiça, Classificação, Qualificação e Títulos (DJCQT - Brazil)
     * rating.
     * The value may be `null`.
     */
    val djctqRating: String? = null,
    /**
     * Reasons that explain why the video received its DJCQT (Brazil) rating.
     * The value may be `null`.
     */
    val djctqRatingReasons: List<String>? = null,
    /**
     * Rating system in Turkey - Evaluation and Classification Board of the Ministry of Culture and
     * Tourism
     * The value may be `null`.
     */
    val ecbmctRating: String? = null,
    /**
     * The video's rating in Estonia.
     * The value may be `null`.
     */
    val eefilmRating: String? = null,
    /**
     * The video's rating in Egypt.
     * The value may be `null`.
     */
    val egfilmRating: String? = null,
    /**
     * The video's Eirin (映倫) rating. Eirin is the Japanese rating system.
     * The value may be `null`.
     */
    val eirinRating: String? = null,
    /**
     * The video's rating from Malaysia's Film Censorship Board.
     * The value may be `null`.
     */
    val fcbmRating: String? = null,
    /**
     * The video's rating from Hong Kong's Office for Film, Newspaper and Article Administration.
     * The value may be `null`.
     */
    val fcoRating: String? = null,
    /**
     * This property has been deprecated. Use the contentDetails.contentRating.cncRating instead.
     * The value may be `null`.
     */
    val fmocRating: String? = null,
    /**
     * The video's rating from South Africa's Film and Publication Board.
     * The value may be `null`.
     */
    val fpbRating: String? = null,
    /**
     * Reasons that explain why the video received its FPB (South Africa) rating.
     * The value may be `null`.
     */
    val fpbRatingReasons: List<String>? = null,
    /**
     * The video's Freiwillige Selbstkontrolle der Filmwirtschaft (FSK - Germany) rating.
     * The value may be `null`.
     */
    val fskRating: String? = null,
    /**
     * The video's rating in Greece.
     * The value may be `null`.
     */
    val grfilmRating: String? = null,
    /**
     * The video's Instituto de la Cinematografía y de las Artes Audiovisuales (ICAA - Spain) rating.
     * The value may be `null`.
     */
    val icaaRating: String? = null,
    /**
     * The video's Irish Film Classification Office (IFCO - Ireland) rating. See the IFCO website for
     * more information.
     * The value may be `null`.
     */
    val ifcoRating: String? = null,
    /**
     * The video's rating in Israel.
     * The value may be `null`.
     */
    val ilfilmRating: String? = null,
    /**
     * The video's INCAA (Instituto Nacional de Cine y Artes Audiovisuales - Argentina) rating.
     * The value may be `null`.
     */
    val incaaRating: String? = null,
    /**
     * The video's rating from the Kenya Film Classification Board.
     * The value may be `null`.
     */
    val kfcbRating: String? = null,
    /**
     * The video's NICAM/Kijkwijzer rating from the Nederlands Instituut voor de Classificatie van
     * Audiovisuele Media (Netherlands).
     * The value may be `null`.
     */
    val kijkwijzerRating: String? = null,
    /**
     * The video's Korea Media Rating Board (영상물등급위원회) rating. The KMRB rates videos in South Korea.
     * The value may be `null`.
     */
    val kmrbRating: String? = null,
    /**
     * The video's rating from Indonesia's Lembaga Sensor Film.
     * The value may be `null`.
     */
    val lsfRating: String? = null,
    /**
     * The video's rating from Malta's Film Age-Classification Board.
     * The value may be `null`.
     */
    val mccaaRating: String? = null,
    /**
     * The video's rating from the Danish Film Institute's (Det Danske Filminstitut) Media Council for
     * Children and Young People.
     * The value may be `null`.
     */
    val mccypRating: String? = null,
    /**
     * The video's rating system for Vietnam - MCST
     * The value may be `null`.
     */
    val mcstRating: String? = null,
    /**
     * The video's rating from Singapore's Media Development Authority (MDA) and, specifically, it's
     * Board of Film Censors (BFC).
     * The value may be `null`.
     */
    val mdaRating: String? = null,
    /**
     * The video's rating from Medietilsynet, the Norwegian Media Authority.
     * The value may be `null`.
     */
    val medietilsynetRating: String? = null,
    /**
     * The video's rating from Finland's Kansallinen Audiovisuaalinen Instituutti (National
     * Audiovisual Institute).
     * The value may be `null`.
     */
    val mekuRating: String? = null,
    /**
     * The rating system for MENA countries, a clone of MPAA. It is needed to prevent titles go live
     * w/o additional QC check, since some of them can be inappropriate for the countries at all. See
     * b/33408548 for more details.
     * The value may be `null`.
     */
    val menaMpaaRating: String? = null,
    /**
     * The video's rating from the Ministero dei Beni e delle Attività Culturali e del Turismo
     * (Italy).
     * The value may be `null`.
     */
    val mibacRating: String? = null,
    /**
     * The video's Ministerio de Cultura (Colombia) rating.
     * The value may be `null`.
     */
    val mocRating: String? = null,
    /**
     * The video's rating from Taiwan's Ministry of Culture (文化部).
     * The value may be `null`.
     */
    val moctwRating: String? = null,
    /**
     * The video's Motion Picture Association of America (MPAA) rating.
     * The value may be `null`.
     */
    val mpaaRating: String? = null,
    /**
     * The rating system for trailer, DVD, and Ad in the US. See
     * http://movielabs.com/md/ratings/v2.3/html/US_MPAAT_Ratings.html.
     * The value may be `null`.
     */
    val mpaatRating: String? = null,
    /**
     * The video's rating from the Movie and Television Review and Classification Board (Philippines).
     * The value may be `null`.
     */
    val mtrcbRating: String? = null,
    /**
     * The video's rating from the Maldives National Bureau of Classification.
     * The value may be `null`.
     */
    val nbcRating: String? = null,
    /**
     * The video's rating in Poland.
     * The value may be `null`.
     */
    val nbcplRating: String? = null,
    /**
     * The video's rating from the Bulgarian National Film Center.
     * The value may be `null`.
     */
    val nfrcRating: String? = null,
    /**
     * The video's rating from Nigeria's National Film and Video Censors Board.
     * The value may be `null`.
     */
    val nfvcbRating: String? = null,
    /**
     * The video's rating from the Nacionãlais Kino centrs (National Film Centre of Latvia).
     * The value may be `null`.
     */
    val nkclvRating: String? = null,
    /**
     * The National Media Council ratings system for United Arab Emirates.
     * The value may be `null`.
     */
    val nmcRating: String? = null,
    /**
     * The video's Office of Film and Literature Classification (OFLC - New Zealand) rating.
     * The value may be `null`.
     */
    val oflcRating: String? = null,
    /**
     * The video's rating in Peru.
     * The value may be `null`.
     */
    val pefilmRating: String? = null,
    /**
     * The video's rating from the Hungarian Nemzeti Filmiroda, the Rating Committee of the National
     * Office of Film.
     * The value may be `null`.
     */
    val rcnofRating: String? = null,
    /**
     * The video's rating in Venezuela.
     * The value may be `null`.
     */
    val resorteviolenciaRating: String? = null,
    /**
     * The video's General Directorate of Radio, Television and Cinematography (Mexico) rating.
     * The value may be `null`.
     */
    val rtcRating: String? = null,
    /**
     * The video's rating from Ireland's Raidió Teilifís Éireann.
     * The value may be `null`.
     */
    val rteRating: String? = null,
    /**
     * The video's National Film Registry of the Russian Federation (MKRF - Russia) rating.
     * The value may be `null`.
     */
    val russiaRating: String? = null,
    /**
     * The video's rating in Slovakia.
     * The value may be `null`.
     */
    val skfilmRating: String? = null,
    /**
     * The video's rating in Iceland.
     * The value may be `null`.
     */
    val smaisRating: String? = null,
    /**
     * The video's rating from Statens medieråd (Sweden's National Media Council).
     * The value may be `null`.
     */
    val smsaRating: String? = null,
    /**
     * The video's TV Parental Guidelines (TVPG) rating.
     * The value may be `null`.
     */
    val tvpgRating: String? = null,
    /**
     * A rating that YouTube uses to identify age-restricted content.
     * The value may be `null`.
     */
    val ytRating: String? = null,
)
