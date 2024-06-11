package com.home.web.exeption

class AppUserNotFoundException(message: String, exception: Exception = Exception(message)) :
    Exception(message, exception)