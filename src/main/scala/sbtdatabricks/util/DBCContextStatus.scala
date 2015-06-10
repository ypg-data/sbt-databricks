package sbtdatabricks.util

sealed trait DBCContextStatus { val status: String }
case object DBCContextRunning extends DBCContextStatus { override val status = "Running" }
case object DBCContextPending extends DBCContextStatus { override val status = "Pending" }
case object DBCContextError extends DBCContextStatus { override val status = "Error" }
