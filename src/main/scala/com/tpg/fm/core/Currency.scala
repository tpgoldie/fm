package com.tpg.fm.core

import com.tpg.fm.asset.{X, Y}

sealed abstract class Currency(name: String, code: String, symbol: String) extends X with Y {
  override def X: X = this
  override def Y: Y = this
}

case object USD extends Currency("Dollar", "USD", "$")

case object EURO extends Currency("Euro", "EUR", "€")

case object GBP extends Currency("Sterling", "GBP", "£")