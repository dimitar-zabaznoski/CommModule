package mk.webfactory.dz.comm.core

import io.reactivex.Completable

abstract class ChannelAdapter {

    /**
     * Checks if a connection with a device is established.
     *
     * @return true if a device is connected, false otherwise
     */
    abstract var isConnected: Boolean
        protected set

    abstract var isDeviceSet: Boolean
        protected set

    abstract var deviceSet: Device?
        protected set

    abstract fun openConnection(): Completable

    abstract fun closeConnection(): Completable
}
