import java.util.Date;

public interface Worktime {

	private Date date;

	private Date onworkTime;

	private Date offworkTime;

	public double getDayWorktime();

	public void amendOnWork();

	public void amendOffWork();

}
