package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private XorGate xorGateLeft;
	private XorGate xorGateRight;
	private AndGate andGateTop;
	private AndGate andGateBottom;
	private OrGate orGate;
	
	public FullGate(){
		super(3,2);
		name = "FULL";
		
		xorGateLeft = new XorGate();
		xorGateRight = new XorGate();
		andGateTop = new AndGate();
		andGateBottom = new AndGate();
		orGate = new OrGate();
		
		xorGateRight.connect(xorGateLeft, 0);
		andGateTop.connect(xorGateLeft, 0);
		orGate.connect(andGateTop, 0);
		orGate.connect(andGateBottom, 1);
	}
	@Override
	protected boolean doRead(int index) {
		// TODO Auto-generated method stub
		if(index == 0){
			return xorGateRight.read();
		}
		else{
			return orGate.read();
		}
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		// TODO Auto-generated method stub
		switch(index){
		case 0:
			xorGateLeft.connect(emitter, 0);
			andGateBottom.connect(emitter, 0);
			break;
		case 1:
			xorGateLeft.connect(emitter, 1);
			andGateBottom.connect(emitter, 1);
			break;
		case 2:
			xorGateRight.connect(emitter, 1);
			andGateTop.connect(emitter, 1);
			break;
		}
	}


}
