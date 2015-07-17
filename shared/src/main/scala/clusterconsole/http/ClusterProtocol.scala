package clusterconsole.http

sealed trait ClusterProtocol

trait ClusterEvent extends ClusterProtocol

/*
** EVENTS
 */

case class ClusterUnjoin(system: String, seedNodes: List[HostPort]) extends ClusterEvent

case class ClusterMemberUp(member: String) extends ClusterEvent
case class ClusterMemberUnreachable(member: String) extends ClusterEvent
case class ClusterMemberRemoved(member: String) extends ClusterEvent

case class DiscoveryBegun(system: String, seedNodes: List[HostPort]) extends ClusterEvent

case class Discovered(system: String) extends ClusterEvent

case class DiscoveredCluster(
            name:String,
            seeds:List[HostPort],
            status: String,
            members:Seq[ClusterMember] = Nil) extends ClusterEvent

/*
** COMMANDS
 */

case class Discover(system: String, seedNodes: List[HostPort]) extends ClusterProtocol

case class ClusterSubscribe(name: String) extends ClusterProtocol

/*
** DEBUG
 */

case class TestResponse(v: String) extends ClusterProtocol

/*
** OTHER
 */

case class ClusterMember(name: String)

case class HostPort(host: String, port: Int)


case class ClusterForm(name:String, seeds:List[HostPort])

object ClusterForm {
  def initial:ClusterForm = ClusterForm("",List(HostPort("",0)))
}


