package mk.webfactory.dz.comm.core

import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.properties.Delegates

abstract class CommunicationChannelBaseTest {

    private var communicationChannel: CommunicationChannel by Delegates.notNull()

    protected abstract fun createInstance(): CommunicationChannel

    @Before
    fun setup() {
        communicationChannel = createInstance()
    }

    @After
    fun tearDown() {
        communicationChannel.closeConnection()
    }

    @Test
    fun testOpenConnection() {
        assertFalse(communicationChannel.isConnected)
        communicationChannel.openConnection().blockingAwait()
        assertTrue(communicationChannel.isConnected)
    }

    @Test
    fun testCloseConnection() {
        communicationChannel.openConnection().blockingAwait()
        assertTrue(communicationChannel.isConnected)
        communicationChannel.closeConnection().blockingAwait()
        assertFalse(communicationChannel.isConnected)
    }
}