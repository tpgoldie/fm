package com.tpg.fm.core

/**
  * Created by tpgoldie on 26/07/16.
  */
sealed abstract class Currency(name: String, code: String, symbol: String) {
}

case object USD extends Currency("Dollar", "USD", "$")

case object EURO extends Currency("Euro", "EUR", "€")

case object GBP extends Currency("Sterling", "GBP", "£")