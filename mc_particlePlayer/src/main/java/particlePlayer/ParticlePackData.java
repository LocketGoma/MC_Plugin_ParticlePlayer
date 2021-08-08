package particlePlayer;
import java.io.Serializable;

public class ParticlePackData implements Serializable {

	private static final long serialVersionUID = -4121289254615132708L;

	private String _sParticleName;			//파티클 네임 : 고유 이름 (사실 별 필요없음)
	private String _sItemType;				//세팅된 아이템 타입
	private String _sLevel;					//등급
	private String _sParticleType;			//파티클 종류
	private String _sParticleStyle;			//파티클 출력 스타일
	private double _fParticleSize;			//파티클 출력 사이즈 (xyz 공통)
	private double _fParticleSpeed;			//파티클 출력 스피드
	private int _iParticleCount;			//단위 파트당 파티클 출력 개수
	
	public ParticlePackData (String sParticleName, String sItemtype, String sLevel, String sParticleType, String sParticleStyle)
	{
		this._sParticleName = sParticleName;
		this._sItemType = sItemtype;
		this._sLevel = sLevel;
		
		this._sParticleType = sParticleType;
		this._sParticleStyle = sParticleStyle;
		this._fParticleSize = 1.0;
		this._fParticleSpeed = 1.0;
		this._iParticleCount = 10;
	}
	
	public ParticlePackData (String sParticleName, String sItemtype, String sLevel, String sParticleType, String sParticleStyle, double fParticleSize, double fParticleSpeed, int iParticleCount )
	{
		this._sParticleName = sParticleName;
		this._sItemType = sItemtype;
		this._sLevel = sLevel;
		
		this._sParticleType = sParticleType;
		this._sParticleStyle = sParticleStyle;
		this._fParticleSize = fParticleSize;
		this._fParticleSpeed = fParticleSpeed;
		this._iParticleCount = iParticleCount;
	}
	
	@Override
	public String toString()
	{
		return String.format("ParticlePack {\n  type='%s'\n  style='%s'\n  size='%s'\n  speed='%s'\n  count='%s'\n}", 
				_sParticleType,
				_sParticleStyle,
				_fParticleSize,
				_fParticleSpeed,
				_iParticleCount);
	}
	
	public String get_sParticleName() {
		return _sParticleName;
	}
	public String get_sItemType() {
		return _sItemType;
	}
	public String get_sLevel() {
		return _sLevel;
	}	
	public String get_sParticleType() {
		return _sParticleType;
	}
	public String get_sPartticleStyle() {
		return _sParticleStyle;
	}
	public double get_fParticleSize() {
		return _fParticleSize;
	}
	public double get_fParticleSpeed() {
		return _fParticleSpeed;
	}
	public int get_iParticleCount() {
		return _iParticleCount;
	}
	
	

	public void set_sParticleName(String _sParticleName) {
		this._sParticleName = _sParticleName;
	}
	public void set_sItemType(String _sItemType) {
		this._sItemType = _sItemType;
	}
	public void set_sLevel(String _sLevel) {
		this._sLevel = _sLevel;
	}	
	public void set_sParticleType(String _sParticleType) {
		this._sParticleType = _sParticleType;
	}
	public void set_sPartticleStyle(String _sPartticleStyle) {
		this._sParticleStyle = _sPartticleStyle;
	}
	public void set_fParticleSize(double _fParticleSize) {
		this._fParticleSize = _fParticleSize;
	}
	public void set_fParticleSpeed(double _fParticleSpeed) {
		this._fParticleSpeed = _fParticleSpeed;
	}
	public void set_iParticleCount(int _iParticleCount) {
		this._iParticleCount = _iParticleCount;
	}
}
