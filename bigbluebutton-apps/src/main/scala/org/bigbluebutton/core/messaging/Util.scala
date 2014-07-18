package org.bigbluebutton.core.messaging

import org.bigbluebutton.core.api._
import com.google.gson.Gson

object Util {
  
  val VERSION = "version"
  
  def buildHeader(name: String, version: String, 
      replyTo:Option[String]):java.util.HashMap[String, Any] = {
    val header = new java.util.HashMap[String, Any]()
    header.put(Constants.NAME, name)
    header.put(VERSION, version)
    header.put(Constants.TIMESTAMP, TimestampGenerator.generateTimestamp)
    replyTo.foreach(rep => header.put(Constants.REPLY_TO, rep))
    
    header
  }
  
  
  def buildJson(header: java.util.HashMap[String, Any], 
      payload: java.util.HashMap[String, Any]): String = {
    
    val message = new java.util.HashMap[String, java.util.HashMap[String, Any]]()
    message.put(Constants.HEADER, header)
    message.put(Constants.PAYLOAD, payload)
    
    val gson = new Gson()
    gson.toJson(message)
  }
}