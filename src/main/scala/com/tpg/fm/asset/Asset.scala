package com.tpg.fm.asset

import org.joda.time.DateTime

trait Asset {
  def t: DateTime
}

trait X extends Asset {
  def X: X
}

trait Y extends Asset {
  def Y: Y
}