package mk.webfactory.dz.comm.core

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.functions.Action
import io.reactivex.subjects.PublishSubject
import java.lang.IllegalStateException

/**
 * Mock implementation of [CommunicationChannel] that transmits back the received messages.
 */
class ParrotChannel(device: Device) : CommunicationChannel() {

    private val messageTransmitter = PublishSubject.create<String>()

    override var isConnected: Boolean = false

    override var isDeviceSet: Boolean = true

    override var deviceSet: Device? = device

    override fun openConnection() = Completable.fromAction { isConnected = true }

    override fun closeConnection() = Completable.fromAction { isConnected = false }

    @Throws(IllegalStateException::class)
    override fun sendMessage(message: String) {
        ensureChannelConnected()
        messageTransmitter.onNext(message)
    }

    override fun messageReceiver(): Observable<String> {
        return messageTransmitter.hide()
    }
}
