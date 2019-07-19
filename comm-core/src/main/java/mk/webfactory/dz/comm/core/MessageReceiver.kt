package mk.webfactory.dz.comm.core

import io.reactivex.Observable
import io.reactivex.annotations.CheckReturnValue

interface MessageReceiver {

    @CheckReturnValue
    fun messageReceiver(): Observable<String>
}
