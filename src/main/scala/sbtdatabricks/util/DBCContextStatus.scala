package sbtdatabricks.util

sealed trait DBCContextStatus { def status: String }
case object DBCContextRunning extends DBCContextStatus { def status = "Running" }
case object DBCContextPending extends DBCContextStatus { def status = "Pending" }
case object DBCContextError extends DBCContextStatus { def status = "Error" }