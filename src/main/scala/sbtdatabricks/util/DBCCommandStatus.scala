package sbtdatabricks.util

sealed trait DBCCommandStatus { val status: String }
case object DBCCommandQueued extends DBCCommandStatus { override val status = "Queued" }
case object DBCCommandRunning extends DBCCommandStatus { override val status = "Running" }
case object DBCCommandCancelling extends DBCCommandStatus { override val status = "Cancelling" }
case object DBCCommandFinished extends DBCCommandStatus { override val status = "Finished" }
case object DBCCommandCancelled extends DBCCommandStatus { override val status = "Cancelled" }
case object DBCCommandError extends DBCCommandStatus { override val status = "Error" }
