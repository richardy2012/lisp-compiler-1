package com.joescii.lisp

import com.joescii.jvmc.HelloWorld
import java.io.{FileOutputStream, File}

object CompilerMain extends App {
  if(args.length < 2){
    println("Usage: lispc <src> <target>")
    System exit 1
  }

  val srcName = args(0)
  val targetName = args(1)

  val src = new File(srcName)
  val target = new File(targetName)

  if(!target.isDirectory) {
    println("<target> must be a writable directory")
    System exit 1
  }

  Compiler.compile(src, target)
}

object Compiler {
  def compile(src:File, target:File) = {
    val jite = HelloWorld.jite

    val helloClassFile = new File(target, "HelloJite.class")
//    if(helloClassFile.exists()) helloClassFile.delete()

    val outStream = new FileOutputStream(helloClassFile)
    outStream.write(jite.toBytes)
    outStream.close()
  }
}
