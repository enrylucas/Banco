package br.edu.unifei.darksouls3

import scala.slick.driver.PostgresDriver.simple._


  object Categoria extends Enumeration {
    type Categoria = Value
    val A = Value("adaga")
    val B = Value("espada")
    val C = Value("katana")
  }
