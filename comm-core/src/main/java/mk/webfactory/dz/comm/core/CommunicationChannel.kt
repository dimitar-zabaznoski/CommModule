package mk.webfactory.dz.comm.core

import java.lang.IllegalStateException

/**
 * A communication channel between our app and a remote device.
 */
abstract class CommunicationChannel : ChannelAdapter(), MessageTransmitter, MessageReceiver {

    @Throws(IllegalStateException::class)
    protected fun ensureChannelConnected() {
        if (!isConnected) {
            throw IllegalStateException("Not connected.")
        }
    }
}
