package br.edu.unifei.darksouls3.models

import scala.slick.driver.PostgresDriver.simple._

  object Categoria extends Enumeration {
    type Categoria = Value
    val adaga = Value("Adaga")
    val espada = Value("Espada")
    val espadaGrande = Value("Espada Grande")
    val ultraEspadaGrande = Value("Ultra Espada Grande")
    val espadaCurva = Value("Espada Curva")
    val katana = Value("Katana")
    val espadaGrandeCurva = Value("Espada Grande Curva")
    val espadaPerfurante = Value("Espada Perfurante")
    val machado = Value("Machado")
    val machadoGrande = Value("Machado Grande")
    val martelo = Value("Martelo")
    val marteloGrande = Value("Martelo Grande")
    val manopla = Value("Manopla")
    val garra = Value("Garra")
    val lanca = Value("Lanca")
    val pique = Value("Pique")
    val halberd = Value("Halberd")
    val foice = Value("Foice")
    val chicote = Value("Chicote")
    val arco = Value("Arco")
    val arcoGrande = Value("Arco Grande")
    val besta = Value("Besta")
    val cajado = Value("Cajado")
    val chama = Value("Chama")
    val talisma = Value("Talisma")
    val sinoSagrado = Value("Sino Sagrado")
    val elmo = Value("Elmo")
    val armadura = Value("Armadura")
    val calca = Value("Calca")
    val botas = Value("Botas")
    val escudo = Value("Escudo")
    val unknown = Value("Unknown")



    implicit val enumMapper = MappedColumnType.base[Categoria, String](_.toString, this.withName)
  }
