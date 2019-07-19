package mk.webfactory.dz.comm.core

import org.mockito.Mockito

class ParrotChannelTest : CommunicationChannelBaseTest() {

    private val device: Device = Mockito.mock(Device::class.java)

    override fun createInstance(): CommunicationChannel = ParrotChannel(device)
}