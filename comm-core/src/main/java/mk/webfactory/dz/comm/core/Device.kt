package mk.webfactory.dz.comm.core

open class Device protected constructor(val id: String,
                                        var friendlyName: String = id.take(30))
