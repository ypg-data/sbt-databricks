package sbtdatabricks.util

sealed trait DBCContextStatus { def status: String }
case object DBCContextRunning extends DBCContextStatus { val status = "Running" }
case object DBCContextPending extends DBCContextStatus { val status = "Pending" }
case object DBCContextError extends DBCContextStatus { val status = "Error" }