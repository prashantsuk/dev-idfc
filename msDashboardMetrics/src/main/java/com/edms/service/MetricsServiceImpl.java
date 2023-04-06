package com.edms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.edms.model.AssetsEntity;
import com.edms.model.LiabilitiesEntity;
import com.edms.model.MetricsResponse;
import com.edms.model.SourceChannels;
import com.edms.repository.AssetsRepository;
import com.edms.repository.LiabilitiesRepository;
import com.edms.repository.SourceChannelRepository;
import com.edms.util.Constants;
import com.google.common.collect.Iterators;

import jakarta.inject.Inject;

public class MetricsServiceImpl implements MetricsService {

	@Inject
	LiabilitiesRepository liabilitiesRepository;

	@Inject
	SourceChannelRepository sourceChannelRepository;

	@Inject
	AssetsRepository assetsRepository;

	/**
	 * @author Koistubh Kasadiwar Get Metrics Data for Liabilities
	 * @throws Exception 
	 */
	public List<MetricsResponse> getLiabilitiesMetricsData() throws Exception {
		List<MetricsResponse> result = new ArrayList<>();
			List<SourceChannels> channels = getAllChannels(Constants.LIABILITY_CATEGORY);
			List<LiabilitiesEntity> allRec = liabilitiesRepository.findAll();
			Integer totalRecords = Iterators.size(allRec.iterator());
			for (SourceChannels sch : channels) {
				var filter = allRec.stream().filter(e -> e.getSourceName().equals(sch.getSourceName()))
						.collect(Collectors.toList());
				Integer channelSize = filter.size();
				MetricsResponse ms = new MetricsResponse();

				float percentage = (float) channelSize / totalRecords;

				ms.setPercentage(percentage * 100);
				ms.setNumberOfRecords(channelSize);
				ms.setSourceId(sch.getSourceId());
				ms.setSourceName(sch.getSourceName());
				result.add(ms);
			}
		return result;
	}

	/**
	 * @author Koistubh Kasadiwar Get Assets Metrics Data
	 * @throws Exception 
	 */

	public List<MetricsResponse> getAssetsMetricsData() throws Exception {
		List<MetricsResponse> result = new ArrayList<>();

			List<SourceChannels> channels = getAllChannels(Constants.ASSET_CATEGORY);
			List<AssetsEntity> allRec = assetsRepository.findAll();
			Integer totalRecords = Iterators.size(allRec.iterator());
			for (SourceChannels sch : channels) {
				var res = allRec.stream().filter(e -> e.getSourceName().equals(sch.getSourceName()))
						.collect(Collectors.toList());
				Integer channelSize = res.size();
				MetricsResponse ms = new MetricsResponse();

				float percentage = (float) channelSize / totalRecords;

				ms.setPercentage(percentage * 100);
				ms.setNumberOfRecords(channelSize);
				ms.setSourceId(sch.getSourceId());
				ms.setSourceName(sch.getSourceName());
				result.add(ms);
			}
		return result;
	}

	/**
	 * @author Koistubh Kasadiwar Get All Source Channels for categories
	 * @throws Exception 
	 */
	public List<SourceChannels> getAllChannels(String category) throws Exception {

		return sourceChannelRepository.findByCategory(category);
	}
}
