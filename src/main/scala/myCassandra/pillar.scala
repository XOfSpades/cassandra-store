package myCassandra

import java.util.Date
import com.chrisomeara.pillar._
import com.datastax.driver.core.Session

object Pillar {

  private val registry = Registry(loadMigrationsFromJarOrFilesystem())
  private val migrator = new CassandraMigrator(registry)

  private def loadMigrationsFromJarOrFilesystem() = {
    val migrationsDir = "migrations/"
    val migrationNames = JarUtils.getResourceListing(getClass, migrationsDir)
                                 .toList.filter(_.nonEmpty)

    val parser = Parser()

    migrationNames.map {
      name => {
        getClass.getClassLoader.getResourceAsStream(migrationsDir + name)
      }
    }.map {
      stream =>
        try {
          parser.parse(stream)
        } finally {
          stream.close()
        }
    }.toList
  }

  def initialize(session: Session, keyspace: String, replicationFactor: Int): Unit = {
    migrator.initialize(
      session,
      keyspace,
      new ReplicationOptions(Map("class" -> "SimpleStrategy", "replication_factor" -> replicationFactor))
    )
  }

  def migrate(session: Session): Unit = {
    val appliedMigrations = AppliedMigrations(session, registry)

    migrator.migrate(session)
  }
}
