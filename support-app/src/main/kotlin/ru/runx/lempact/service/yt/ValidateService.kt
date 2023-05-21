package ru.runx.lempact.service.yt

import ru.runx.lempact.dto.dataset.CheckModelDto

interface ValidateService {

    fun score(request: CheckModelDto)

}
