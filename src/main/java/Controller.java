import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {

	public static void main(String[] args) throws Exception {
		
		final int MAX_CRAWL_DEPTH = 1;
        final int NUMBER_OF_CRAWELRS = 2;
        final String CRAWL_STORAGE = "/data/crawl/root";

        /*
         * Instantiate crawl config
         */
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(CRAWL_STORAGE);
        config.setMaxDepthOfCrawling(MAX_CRAWL_DEPTH);

        /*
         * Instantiate controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);


        /*
         * Add seed URLs
         */
//        controller.addSeed("http://srilanka.travel-culture.com/sri-lanka-gov-links.shtml");
        controller.addSeed("https://www.york.ac.uk/teaching/cws/wws/webpage1.html");

        /*
         * Start the crawl.
         */
        controller.start(MyCrawler.class, NUMBER_OF_CRAWELRS);
	}

}
